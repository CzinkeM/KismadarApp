package com.example.kismadrapp.models

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import com.example.kismadrapp.R

class Restaurant(): Location("",null) {
    lateinit var restaurantName: String
    lateinit var restaurantImage: Drawable

    private constructor(name: String, image: Drawable): this(){
        this.locationName = name
        this.locationImage = image

        this.restaurantName = name
        this.restaurantImage = image
    }
    private class Builder(
        private var restaurantName: String? = null,
        private var restaurantImage: Drawable? = null
    ){
        fun name(restaurantName: String) = apply { this.restaurantName = restaurantName }
        fun image(restaurantImage: Drawable) = apply { this.restaurantImage = restaurantImage }
        fun build() = Restaurant(restaurantName!!,restaurantImage!!)
    }
    fun getAll(context: Context): ArrayList<Restaurant>{
        val restaurants = arrayListOf<Restaurant>()
        val rozmaring = Builder()
            .name("RozmaringÉtterem")
            .image(ResourcesCompat.getDrawable(context.resources, R.drawable.vector_food,null)!!)
            .build()
        restaurants.add(rozmaring)
        return restaurants
    }
    override fun getCategory(context: Context): String {
        return context.getString(R.string.category_food_drink)
    }

}