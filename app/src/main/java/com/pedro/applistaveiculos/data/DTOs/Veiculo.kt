package com.pedro.applistaveiculos.data.DTOs
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Veiculo(
    val id: Int,
    val placa: String,
    val modelo: String,
    val marca: String,
    val ano: Int,
    val cor: String,
    val chassi: String,
    val renavam: String
) : Parcelable