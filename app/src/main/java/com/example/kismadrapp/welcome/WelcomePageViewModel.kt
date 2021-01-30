package com.example.kismadrapp.welcome

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kismadrapp.R
import com.example.kismadrapp.model.Category
import com.example.kismadrapp.model.Town

class WelcomePageViewModel:ViewModel(){
    private val _list = MutableLiveData<List<Category>>()
    fun getList(): LiveData<List<Category>>{
            return  _list
    }

    fun generateList(icon: Drawable){
        val cat1 = Category(1,icon,"category1")
        val cat2 = Category(1,icon,"category2")
        val cat3 = Category(1,icon,"category3")
        val list = mutableListOf(cat1,cat2,cat3,cat2,cat3,cat1,cat2,cat3,cat2,cat3,cat1,cat2,cat3,cat2,cat3,cat1)
        _list.value = list
    }
    fun townList(icon: Drawable):List<Town>{
        val town1 = Town(1,"Noszvaj",icon)
        val town2 = Town(2,"Szomolya",icon)
        val town3 = Town(3,"Bogács",icon)
        return  listOf(town1,town2,town3,town1,town2,town3)
    }
}