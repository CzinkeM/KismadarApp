package com.example.kismadrapp.models

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import com.example.kismadrapp.R

class Town(): Location("",null) {

    lateinit var townName: String
    lateinit var townDescription: String
    lateinit var townImage: Drawable

    constructor(name: String,description: String, image: Drawable): this(){
        this.locationName = name
        this.locationImage = image

        this.townName = name
        this.townDescription = description
        this.townImage = image
    }
    private class Builder(
        private var townName:String? = null,
        private var townDescription: String? = null,
        private var townImage: Drawable? = null
    ){
        fun name(townName: String) = apply { this.townName = townName }
        fun description(description: String) = apply { this.townDescription = description }
        fun image(townImage: Drawable) = apply { this.townImage = townImage }
        fun build() = Town(townName!!,townDescription!!,townImage!!)
    }
    fun getAll(context: Context): ArrayList<Town>{
        val towns = arrayListOf<Town>()
        val eger = Builder()
            .name(context.getString(R.string.town_name_eger))
            .description("Ez egy szép város")
            .image(ResourcesCompat.getDrawable(context.resources,R.drawable.img_eger,null)!!)
            .build()
        towns.add(eger)

        return towns
    }



    override fun getCategory(context: Context): String {
        TODO("Not yet implemented")
    }
}