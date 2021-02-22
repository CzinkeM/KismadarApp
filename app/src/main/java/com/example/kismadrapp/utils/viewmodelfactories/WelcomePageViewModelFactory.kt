package com.example.kismadrapp.utils.viewmodelfactories

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kismadrapp.viewmodels.WelcomePageViewModel

class WelcomePageViewModelFactory(
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