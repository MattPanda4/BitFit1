package com.matt.bitfit1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao

interface FoodDao {

    @Query("SELECT * FROM foodInfo")

    fun getAll(): Flow<List<CurrentFood>>

    @Insert
    fun insert (foodinfo: CurrentFood)

    @Query ("DELETE FROM foodInfo")
    fun deleteAll()

}