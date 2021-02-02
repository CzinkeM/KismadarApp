package com.example.kismadrapp.welcome

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class WelcomePageViewModelFactory (
    private val res: Resources
    ) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WelcomePageViewModel::class.java)) {
            return WelcomePageViewModel(res) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}