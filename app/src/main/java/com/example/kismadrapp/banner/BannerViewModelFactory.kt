package com.example.kismadrapp.banner

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kismadrapp.welcome.WelcomePageViewModel

class BannerViewModelFactory (
    private val res: Resources
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BannerViewModel::class.java)) {
            return BannerViewModel(res) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}