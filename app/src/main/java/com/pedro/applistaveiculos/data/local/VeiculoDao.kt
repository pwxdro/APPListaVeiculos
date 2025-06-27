package com.pedro.applistaveiculos.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pedro.applistaveiculos.data.DTOs.Veiculo

/**
 * metodos DAO para inserir os veiculos na tabela do SQLite e selecionar todos os resultados para persistencia dos dados.
 */
@Dao
interface VeiculoDao {
    @Query("SELECT * FROM veiculo")
    suspend fun getAll(): List<Veiculo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(veiculos: List<Veiculo>)
}
