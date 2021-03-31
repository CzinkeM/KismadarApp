package com.example.kismadrapp.viewmodels

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import com.example.kismadrapp.utils.getCategories
import com.example.kismadrapp.models.Category

class WelcomePageViewModel(resources: Resources) : ViewModel() {
    private val res = resources
    private val townList: List<Town>
    fun getTownList() = townList
    private val categoryList: List<Category>
    fun getCategoryList() = categoryList

    init {
        townList = getTownList()
        categoryList = getCategories(resources)
    }
}