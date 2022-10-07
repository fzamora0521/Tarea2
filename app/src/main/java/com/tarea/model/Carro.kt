package com.tarea.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "carro")

data class Carro(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "marca")
    val marca: String,
    @ColumnInfo(name = "modelo")
    val modelo: String,
    @ColumnInfo(name = "anno")
    val anno: Int,
    @ColumnInfo(name = "nPlaca")
    val nPlaca: String?,
    @ColumnInfo(name = "nVIN")
    val nVIN: String?,
    @ColumnInfo(name = "rutaImagen")
    val rutaImagen: String?
) : Parcelable
