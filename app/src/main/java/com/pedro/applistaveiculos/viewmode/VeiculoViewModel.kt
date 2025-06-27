package com.pedro.applistaveiculos.viewmode

import androidx.lifecycle.*
import com.pedro.applistaveiculos.data.DTOs.Veiculo
import com.pedro.applistaveiculos.data.repository.VeiculoRepository
import kotlinx.coroutines.launch
import android.util.Log

/**
 *
 *   ViewModel responsável por gerenciar os dados da lista de veículos.
 *
 *   Ele busca os dados do repositório (API ou banco local), armazena no LiveData,
 *   e expõe para a UI de forma reativa.
 *
 */
class VeiculoViewModel(
    private val repository: VeiculoRepository
) : ViewModel() {

    private val _veiculos = MutableLiveData<List<Veiculo>>()
    val vehicles: LiveData<List<Veiculo>> = _veiculos

    init {
        fetchVeiculos()
    }

    private fun fetchVeiculos() {
        viewModelScope.launch {
            try {
                val list = repository.getVeiculos()
                _veiculos.postValue(list)
            } catch (e: Exception) {
                Log.e("VeiculoViewModel", "Erro ao buscar veículos", e)
            }
        }
    }
}
