package com.example.kismadrapp.utils.viewmodelfactories

import android.content.Context
import android.content.res.Resources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kismadrapp.viewmodels.WelcomePageViewModel

class WelcomePageViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WelcomePageViewModel::class.java)) {
            return WelcomePageViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}