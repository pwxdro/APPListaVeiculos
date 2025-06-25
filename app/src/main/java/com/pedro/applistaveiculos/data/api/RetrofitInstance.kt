package com.pedro.applistaveiculos.data.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://my-json-server.typicode.com/pwxdro/json-server-veiculos/"

    val api: VeiculoApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(VeiculoApi::class.java)
    }
}
