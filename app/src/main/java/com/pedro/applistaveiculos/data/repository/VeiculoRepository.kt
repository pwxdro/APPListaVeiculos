package com.pedro.applistaveiculos.data.repository

import com.pedro.applistaveiculos.data.DTOs.Veiculo
import com.pedro.applistaveiculos.data.api.RetrofitInstance

class VeiculoRepository {
    suspend fun getVeiculos(): List<Veiculo> {
        val response = RetrofitInstance.api.getVeiculos()
        return response.veiculos
    }
}
