package com.example.kismadrapp.welcome

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import com.example.kismadrapp.model.Category
import com.example.kismadrapp.model.Town
import com.example.kismadrapp.utils.EmbeddedValues

class WelcomePageViewModel(resources: Resources):ViewModel(){
    private val data = EmbeddedValues(resources)

    private val townList: List<Town>
    fun getTownList() = townList
    private val categoryList: List<Category>
    fun getCategoryList() = categoryList
    init {
        townList = data.listOfTowns
        categoryList = data.generateCategoryList(resources)
    }
}