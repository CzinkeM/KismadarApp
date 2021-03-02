package com.example.kismadrapp.viewmodels

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import com.example.kismadrapp.models.Town

class WelcomePageViewModel(resources: Resources) : ViewModel() {
    private val res = resources
    private val townList: List<Town>
    fun getTownList() = townList

    init {
        townList = getTownList()
    }
}