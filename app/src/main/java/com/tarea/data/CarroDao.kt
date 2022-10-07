package com.tarea.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tarea.model.Carro

@Dao
interface CarroDao {

    @Query("SELECT * FROM CARRO")
    fun getAllData(): LiveData<List<Carro>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCarro(carro: Carro)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateCarro(carro: Carro)

    @Delete
    suspend fun deleteCarro(carro: Carro)
}