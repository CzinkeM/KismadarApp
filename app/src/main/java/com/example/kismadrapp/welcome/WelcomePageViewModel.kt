package com.example.kismadrapp.welcome

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.CountDownTimer
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.ViewModel
import androidx.palette.graphics.Palette
import com.example.kismadrapp.database.Category
import com.example.kismadrapp.database.Town
import com.example.kismadrapp.model.Lists
import com.example.kismadrapp.model.ImageColors
import kotlin.random.Random

class WelcomePageViewModel(resources: Resources):ViewModel(){
    private val data = Lists()

    private val townList: List<Town>
    fun getTownList() = townList
    private val categoryList: List<Category>
    fun getCategoryList() = categoryList
    init {
        townList = data.generateTownList(resources)
        categoryList = data.generateCategoryList(resources)
    }

}