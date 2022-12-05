package com.example.lugares.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
//@Entity(tableName = "lugar")

data class Lugar(
    //Clase que mapea una tabla de sqlite
    //@PrimaryKey(autoGenerate = true)
    var id: String,
    //@ColumnInfo(name="nombre")
    val nombre: String,
    //@ColumnInfo(name="correo")
    val correo: String?,
    //@ColumnInfo(name="web")
    val web: String?,
    //@ColumnInfo(name="telefono")
    val telefono: String?
) : Parcelable{
    constructor():
            this("","","","","")
}

