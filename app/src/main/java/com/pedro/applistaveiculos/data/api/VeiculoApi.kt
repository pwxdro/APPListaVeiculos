package com.pedro.applistaveiculos.data.api

import com.pedro.applistaveiculos.data.DTOs.VeiculosResponse
import retrofit2.http.GET

/**
 * Rota que será chamada na API instanciada no RetrofitInstance
 */
interface VeiculoApi {
    @GET("db")
    suspend fun getVeiculos(): VeiculosResponse
}