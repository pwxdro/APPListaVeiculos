package com.pedro.applistaveiculos.data.repository

import com.pedro.applistaveiculos.data.DTOs.Veiculo
import com.pedro.applistaveiculos.data.api.RetrofitInstance
import com.pedro.applistaveiculos.data.local.VeiculoDao

class VeiculoRepository(private val dao: VeiculoDao) {
    suspend fun getVeiculos(): List<Veiculo> {
        return try {
            val response = RetrofitInstance.api.getVeiculos().veiculos
            dao.insertAll(response) // Salva no cache
            response
        } catch (e: Exception) {
            dao.getAll() // Se falhar, retorna cache local
        }
    }
}
