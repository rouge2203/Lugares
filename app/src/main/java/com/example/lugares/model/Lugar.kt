package com.example.lugares.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "lugar")

data class Lugar(
    //Clase que mapea una tabla de sqlite
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name="nombre")
    val nombre: String,
    @ColumnInfo(name="correo")
    val correo: String?,
    @ColumnInfo(name="telefono")
    val telefono: String?,
    @ColumnInfo(name="web")
    val web: String,
    @ColumnInfo(name="latitud")
    val latitud: Double?,
    @ColumnInfo(name="longitud")
    val longitud: Double?,
    @ColumnInfo(name="altura")
    val altura: Double?,
    @ColumnInfo(name="rutaAudio")
    val rutaAudio: String?,
    @ColumnInfo(name="rutaImagen")
    val rutaImagen: String?,
) : Parcelable
