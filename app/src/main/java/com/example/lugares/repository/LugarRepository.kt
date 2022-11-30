package com.example.lugares.repository

import androidx.lifecycle.LiveData
import com.example.lugares.data.LugarDao
import com.example.lugares.model.Lugar

class LugarRepository (private val lugarDao: LugarDao) {

    suspend fun saveLugar(lugar: Lugar) {
        if (lugar.id==0) {  //Es un lugar nuevo
            lugarDao.addLugar(lugar)
        } else {  //El lugar existe... entonces se actualiza...
            lugarDao.updateLugar(lugar)
        }
    }

    suspend fun deleteLugar(lugar: Lugar) {
        lugarDao.deleteLugar(lugar)
    }

    val getAllData: LiveData<List<Lugar>> = lugarDao.getAllData()

    //Suspend fun addLugar(lugar: Lugar){
    //   lugarDao.addLugar(lugar)
    //
    //
    //Suspend fun updateLugar(lugar: Lugar){
    //   lugarDao.updateLugar(lugar)
    //
    //
    //Suspend fun deleteLugar(lugar: Lugar){
    //   lugarDao.deleteLugar(lugar)
    //
}