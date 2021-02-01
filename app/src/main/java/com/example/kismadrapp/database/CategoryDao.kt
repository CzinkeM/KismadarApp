package com.example.kismadrapp.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CategoryDao {
    @Insert
    suspend fun insert(category: Category)
    @Update
    suspend fun update(category: Category)
    @Delete
    suspend fun delete(category: Category)
    @Query("SELECT * from categories_table WHERE category_name = :name")
    suspend fun get(name: String): Category
    @Query("DELETE FROM categories_table")
    suspend fun clear()
    @Query("SELECT * FROM categories_table ORDER BY category_name DESC")
    fun getAllCategory(): LiveData<List<Category>>
}