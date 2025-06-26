package com.pedro.applistaveiculos.data.DTOs
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import androidx.room.Entity
import androidx.room.PrimaryKey

@Parcelize
@Entity(tableName = "veiculo")  // nome da tabela (opcional, mas recomendado)
data class Veiculo(
    @PrimaryKey val id: Int,     // Agora Room entende que esse campo é único
    val placa: String,
    val modelo: String,
    val marca: String,
    val ano: Int,
    val cor: String,
    val chassi: String,
    val renavam: String
) : Parcelable