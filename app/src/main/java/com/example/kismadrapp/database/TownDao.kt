package com.example.kismadrapp.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TownDao {
    @Insert
    suspend fun insert(town: Town)
    @Update
    suspend fun update(town: Town)
    @Delete
    suspend fun delete(town: Town)
    @Query("SELECT * from town_table WHERE town_name = :name")
    suspend fun get(name: String): Town
    @Query("DELETE FROM town_table")
    suspend fun clear()
    @Query("SELECT * FROM town_table ORDER BY town_name DESC")
    fun getAllNights(): LiveData<List<Town>>
}