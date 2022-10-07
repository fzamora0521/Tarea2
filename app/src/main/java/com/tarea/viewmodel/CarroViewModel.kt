package com.tarea.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.tarea.data.CarroDatabase
import com.tarea.model.Carro
import com.tarea.repository.CarroRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CarroViewModel(application: Application) : AndroidViewModel(application) {
    val getAllData: LiveData<List<Carro>>

    private val repository: CarroRepository

    init {
        val carroDato = CarroDatabase.getDatabase(application).carroDao()
        repository = CarroRepository(carroDato)
        getAllData = repository.getAllData
    }

    fun saveCarro(carro: Carro) {
        viewModelScope.launch(Dispatchers.IO) { repository.saveCarro(carro) }
    }


    fun deleteCarro(carro: Carro) {
        viewModelScope.launch(Dispatchers.IO) { repository.deleteCarro(carro) }
    }
}