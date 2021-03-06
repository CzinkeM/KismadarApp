package com.example.kismadrapp.models

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.example.kismadrapp.R
import kotlin.collections.ArrayList

class NatureSight() : Location(null,null) {

    lateinit var natureSightName: String
    lateinit var natureSightImage: Drawable

    private constructor(name: String, image: Drawable): this(){
        this.locationName = name
        this.locationImage = image
        this.natureSightName = name
        this.natureSightImage = image
    }
    private class Builder(
        private var sightName:String? = null,
        private var sightImage: Drawable? = null
    ){
        fun name(natureSightName: String) = apply { this.sightName = natureSightName }
        fun image(natureSightImage: Drawable) = apply { this.sightImage = natureSightImage }
        fun build() = NatureSight(sightName!!,sightImage!!)
    }

    fun getAll(context: Context): ArrayList<NatureSight> {
        val natureSights = ArrayList<NatureSight>()
        val hill = Builder()
            .name("imány")
            .image(ContextCompat.getDrawable(context,R.drawable.vector_hiking)!!)
            .build()
        natureSights.add(hill)
        val castle = Builder()
            .name("Forrás")
            .image(ContextCompat.getDrawable(context,R.drawable.vector_hiking)!!)
            .build()
        natureSights.add(castle)
        return natureSights
    }
    override fun equalsToLocation(location: Location): Boolean{
        return this.locationName == location.locationName
    }

    override fun getCategory(context: Context): String{
        return context.getString(R.string.category_nature)
    }
}