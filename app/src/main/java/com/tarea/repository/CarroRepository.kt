package com.tarea.repository

import androidx.lifecycle.LiveData
import com.tarea.data.CarroDao
import com.tarea.model.Carro

class CarroRepository(private val carroDao: CarroDao) {
    val getAllData: LiveData<List<Carro>> = carroDao.getAllData()

    suspend fun saveCarro(carro: Carro) {
        if (carro.id == 0) {
            carroDao.addCarro(carro)
        } else {
            carroDao.updateCarro(carro)
        }
    }

    suspend fun deleteCarro(carro: Carro) {
        carroDao.deleteCarro(carro)
    }
}
