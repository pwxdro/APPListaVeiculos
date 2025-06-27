package com.pedro.applistaveiculos.data.DTOs

/**
 * Objeto veiculos (O Json retorna um objeto Veiculos e dentro dele estão todos os veiculos
 * cadastrados)
 */
data class VeiculosResponse(
    val veiculos: List<Veiculo>
)