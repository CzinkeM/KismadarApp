package com.example.kismadrapp.models

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import com.example.kismadrapp.R

class Shop(): Location("",null) {

    lateinit var shopName: String
    lateinit var shopImage: Drawable

    private constructor(name: String, image: Drawable): this(){
        this.locationName = name
        this.locationImage = image

        this.shopName = name
        this.shopImage = image
    }

    private class Builder(
        private var shopName: String? = null,
        private var shopImage: Drawable? = null
    ){
        fun name(name: String) = apply { this.shopName = name }
        fun image(image: Drawable) = apply { this.shopImage = image }
        fun build() = Shop(shopName!!,shopImage!!)
    }
    fun getAll(context: Context): ArrayList<Shop>{
        val shops = arrayListOf<Shop>()
        val coop = Builder()
            .name("CoopBolt")
            .image(ResourcesCompat.getDrawable(context.resources,R.drawable.vector_shop,null)!!)
            .build()
        shops.add(coop)
        return shops
    }
    override fun equalsToLocation(location: Location): Boolean{
        return this.locationName == location.locationName
    }
    override fun getCategory(context: Context): String {
        return context.getString(R.string.category_shops)
    }
}