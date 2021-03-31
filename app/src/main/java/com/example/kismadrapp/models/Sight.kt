package com.example.kismadrapp.models

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.example.kismadrapp.R

class Sight() : Location("",null) {
    lateinit var sightName: String
    lateinit var sightDescription: String
    var payRequired: Boolean = false
    lateinit var sightImage: Drawable

    private constructor(name: String,description: String, payRequired: Boolean, image: Drawable): this(){
        this.locationName = name
        this.locationImage = image

        this.sightName = name
        this.sightDescription = description
        this.payRequired = payRequired
        this.sightImage = image
    }
    private class Builder(
        private var sightName:String? = null,
        private var sightDescription: String? = null,
        private var payRequired: Boolean = false,
        private var sightImage: Drawable? = null
    ){
        fun name(sightName: String) = apply { this.sightName = sightName }
        fun description(sightDescription: String) = apply { this.sightDescription = sightDescription }
        fun payRequired(payRequired: Boolean) = apply { this.payRequired = payRequired }
        fun image(sightImage: Drawable) = apply { this.sightImage = sightImage }
        fun build() = Sight(sightName!!, sightDescription!!,payRequired, sightImage!!)
    }

    fun getAll(context: Context): ArrayList<Sight> {
        val sights = ArrayList<Sight>()
        val cavern = Builder()
            .name("Barlang Lakások")
            .description(context.getString(R.string.loremipsum)) // TODO: 2021. 03. 31. Change this to real description
            .payRequired(true)
            .image(ContextCompat.getDrawable(context,R.drawable.vector_sight)!!)
            .build()
        sights.add(cavern)
        val castle = Builder()
            .name("De La Motte")
            .description(context.getString(R.string.loremipsum)) // TODO: 2021. 03. 31. Change this to real description
            .payRequired(false)
            .image(ContextCompat.getDrawable(context,R.drawable.vector_sight)!!)
            .build()
        sights.add(castle)
        return sights
    }


    override fun getCategory(context: Context): String {
        return context.getString(R.string.category_sights)
    }
}