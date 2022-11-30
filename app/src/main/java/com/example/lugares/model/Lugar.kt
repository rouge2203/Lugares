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
    @ColumnInfo(name="web")
    val web: String?,
    @ColumnInfo(name="telefono")
    val telefono: String
) : Parcelable
