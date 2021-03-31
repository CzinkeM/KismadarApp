package com.example.kismadrapp.models

import android.content.Context
import android.graphics.drawable.Drawable

class NatureSight() : Location("",null) {
    lateinit var natureSightName: String
    lateinit var natureSightImage: Drawable

    private constructor(name: String, image: Drawable): this(){
        this.locationName = name
        this.natureSightImage = image

        this.natureSightName = name
        this.natureSightImage = image
    }
    private class Builder(
        private var sightName:String? = null,
        private var sightImage: Drawable? = null
    ){
        fun name(natureSightName: String) = apply { this.sightName = sightName }
        fun image(natureSightImage: Drawable) = apply { this.sightImage = sightImage }
        fun build() = NatureSight(sightName!!,sightImage!!)
    }

    override fun getAll(context: Context): ArrayList<Location> {
        TODO("Not yet implemented")
    }

}