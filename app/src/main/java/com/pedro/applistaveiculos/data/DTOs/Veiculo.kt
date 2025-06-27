package com.pedro.applistaveiculos.data.DTOs
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * objeto Veiculo que será preenchido a partir dos dados retornados do JSON.
 * Parcelize para transitar os dados entre as activitys
 * Entity cria a tabela usando o SQLite para persistir os dados no app
 */
@Parcelize
@Entity(tableName = "veiculo")
data class Veiculo(
    @PrimaryKey val id: Int,
    val placa: String,
    val modelo: String,
    val marca: String,
    val ano: Int,
    val cor: String,
    val chassi: String,
    val renavam: String
) : Parcelable