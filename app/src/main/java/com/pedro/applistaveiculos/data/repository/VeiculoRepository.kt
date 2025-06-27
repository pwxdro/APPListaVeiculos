package com.pedro.applistaveiculos.data.repository

import com.pedro.applistaveiculos.data.DTOs.Veiculo
import com.pedro.applistaveiculos.data.api.RetrofitInstance
import com.pedro.applistaveiculos.data.local.VeiculoDao

/**
 * Interface para comunicação entre a viewModel.
 * A partir do response os dados são inseridos na tabela criada na DAO
 * caso de erro na resposta da API são coletados todos os dados já cadastrados na DAO
 */
class VeiculoRepository(private val dao: VeiculoDao) {
    suspend fun getVeiculos(): List<Veiculo> {
        return try {
            val response = RetrofitInstance.api.getVeiculos().veiculos
            dao.insertAll(response) // Salva no cache
            response
        } catch (e: Exception) {
            dao.getAll()
        }
    }
}
