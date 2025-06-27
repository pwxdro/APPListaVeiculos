package com.pedro.applistaveiculos.viewmode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pedro.applistaveiculos.data.repository.VeiculoRepository

/**
 *
 *   Fábrica de ViewModel customizada para criar instâncias de [VeiculoViewModel]
 *   com o repositório injetado via construtor.
 *
 *  Necessário quando o ViewModel precisa de dependências externas.
 */
class VeiculoViewModelFactory(
    private val repository: VeiculoRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VeiculoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return VeiculoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}