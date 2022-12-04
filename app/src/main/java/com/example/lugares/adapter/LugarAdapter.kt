package com.example.lugares.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.lugares.databinding.LugarFilaBinding
import com.example.lugares.model.Lugar
import com.example.lugares.ui.lugar.LugarFragmentDirections
import com.example.lugares.ui.lugar.UpdateLugarFragmentDirections

class LugarAdapter: RecyclerView.Adapter<LugarAdapter.LugarViewHolder>() {

    private var listarLugares = emptyList<Lugar>()

    inner class LugarViewHolder(private var itemBinding: LugarFilaBinding) :
        RecyclerView.ViewHolder(itemBinding.root){

    fun dibujar(lugar: Lugar) {
        itemBinding.tvNombre.text = lugar.nombre
        itemBinding.tvTelefono.text = lugar.telefono
        itemBinding.tvCorreo.text = lugar.correo

        //evento edit
        itemBinding.vistaFila.setOnClickListener {
        val accion = LugarFragmentDirections
            .actionNavLugarToUpdateLugarFragment(lugar)
        itemView.findNavController().navigate(accion)
        }

    }
}

    fun setLugares(lugares: List<Lugar>){
        listarLugares = lugares
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LugarViewHolder{
        val itemBinding = LugarFilaBinding
            .inflate(LayoutInflater.from(parent.context)
            ,parent,false)
        return LugarViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: LugarViewHolder, position: Int) {
        val lugar = listarLugares[position]
        holder.dibujar(lugar)
    }

    override fun getItemCount(): Int{
        return listarLugares.size
    }
//listado de lugara p;ciommo
}