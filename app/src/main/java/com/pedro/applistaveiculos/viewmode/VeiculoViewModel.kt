package com.pedro.applistaveiculos.viewmode

import androidx.lifecycle.*
import com.pedro.applistaveiculos.data.DTOs.Veiculo
import com.pedro.applistaveiculos.data.repository.VeiculoRepository
import kotlinx.coroutines.launch
import android.util.Log


class VeiculoViewModel : ViewModel() {

    private val repository = VeiculoRepository()

    private val veiculos = MutableLiveData<List<Veiculo>>()
    val vehicles: LiveData<List<Veiculo>> = veiculos

    init {
        fetchVeiculos()
    }

    private fun fetchVeiculos() {
        viewModelScope.launch {
            try {
                val list = repository.getVeiculos()
                veiculos.postValue(list)
            } catch (e: Exception) {
                Log.e("VeiculoViewModel", "Erro ao buscar veículos", e)
            }
        }
    }
}
