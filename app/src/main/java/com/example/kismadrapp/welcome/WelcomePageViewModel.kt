package com.example.kismadrapp.welcome

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kismadrapp.R
import com.example.kismadrapp.model.Category
import com.example.kismadrapp.model.Town

class WelcomePageViewModel:ViewModel(){
    private val _list = MutableLiveData<List<Category>>()
    fun getCategoryList(): LiveData<List<Category>>{
        return  _list
    }

    fun generateCategoryList(res: Resources){
        val catFoodDrink = Category(1, ResourcesCompat.getDrawable(res,R.drawable.ic_iconmonstr_restaurant,null),res.getString(R.string.category_food_drink))
        val catServices = Category(1, ResourcesCompat.getDrawable(res,R.drawable.ic_iconmonstr_gear,null),res.getString(R.string.category_services))
        val catShop = Category(1, ResourcesCompat.getDrawable(res,R.drawable.ic_iconmonstr_shop,null),res.getString(R.string.category_shops))
        val catSight = Category(1, ResourcesCompat.getDrawable(res,R.drawable.ic_iconmonstr_building,null),res.getString(R.string.category_sights))
        val catNature = Category(1, ResourcesCompat.getDrawable(res,R.drawable.ic_iconmonstr_tree,null),res.getString(R.string.category_nature))
        val catSurroundings = Category(1, ResourcesCompat.getDrawable(res,R.drawable.ic_iconmonstr_map,null),res.getString(R.string.category_surroundings))
        _list.value =  mutableListOf(catFoodDrink,catServices,catShop,catSight,catNature,catSurroundings)
    }
    fun townList(icon: Drawable):List<Town>{
        val town1 = Town("Noszvaj",icon)
        val town2 = Town("Szomolya",icon)
        val town3 = Town("Bogács",icon)
        return  listOf(town1,town2,town3,town1,town2,town3)
    }
}