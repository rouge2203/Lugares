package com.example.lugares.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.lugares.model.Lugar
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
//import com.google.firebase.firestore.ktx.snapshots
import com.google.firebase.ktx.Firebase


class LugarDao {

    //Firebase var
    private var codigoUsuario: String
    private var firestore: FirebaseFirestore

    init{
        val usuario = Firebase.auth.currentUser?.email
        codigoUsuario = "$usuario"
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    fun saveLugar(lugar: Lugar){
        val document: DocumentReference
        if(lugar.id.isEmpty()){
            //agregar
            document = firestore.
                    collection("lugaresApp").
                    document(codigoUsuario).
                    collection("misLugares").
                    document()
            lugar.id = document.id
        }else{
            //modificar
            document = firestore.
            collection("lugaresApp").
            document(codigoUsuario).
            collection("misLugares").
            document(lugar.id)
        }
        val set = document.set(lugar)
            set.addOnSuccessListener{
                Log.d("saveLugar","Guardado con exito")
            }
            .addOnCanceledListener {
                Log.e("saveLugar","Error al guardar")
            }
    }

    fun deleteLugar(lugar: Lugar){
        if(lugar.id.isNotEmpty()){
            firestore.
                collection("lugaresApp").
                document(codigoUsuario).
                collection("misLugares").
                document(lugar.id).
                delete()
                .addOnSuccessListener{
                    Log.d("deleteLugar","Eliminado con exito")
                }
                .addOnCanceledListener {
                    Log.d("deleteLugar","Error al eliminar")
                }
        }
    }

    fun getLugares() : MutableLiveData<List<Lugar>> {
        val listaLugares = MutableLiveData<List<Lugar>>()
        firestore.
            collection("lugaresApp").
            document(codigoUsuario).
            collection("misLugares").
            addSnapshotListener{ snapshot, e ->
                if(e != null){
                    return@addSnapshotListener
                }
                if(snapshot != null) {
                    val lista = ArrayList<Lugar>()
                    val lugares = snapshot.documents
                    lugares.forEach {
                        val lugar = it.toObject(Lugar ::class.java)
                        if (lugar!=null) {
                            lista.add(lugar)
                        }
                    }
                    listaLugares.value = lista
                }
            }
        return listaLugares
    }
}