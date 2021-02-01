package com.example.kismadrapp.welcome

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kismadrapp.database.CategoryDao
import com.example.kismadrapp.database.TownDao

class WelcomePageViewModelFactory (
    private val context: Context,
    private val townData: TownDao,
    private val categoryData: CategoryDao
    ) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WelcomePageViewModel::class.java)) {
            return WelcomePageViewModel(context,townData,categoryData) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}