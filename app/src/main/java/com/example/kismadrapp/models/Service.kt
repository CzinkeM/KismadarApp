package com.example.kismadrapp.models

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import com.example.kismadrapp.R

class Service(): Location("",null) {
    lateinit var serviceName: String
    lateinit var serviceDescription: String
    lateinit var serviceImage: Drawable

    private constructor(name: String,description: String, image: Drawable): this(){
        this.locationName = name
        this.locationImage = image

        this.serviceName = name
        this.serviceDescription = description
        this.serviceImage = image
    }

    private class Builder(
        private var serviceName: String? = null,
        private var serviceDescription: String? = null,
        private var serviceImage: Drawable? = null
    ){
        fun name(name: String) = apply { this.serviceName = name }
        fun description(description: String) = apply { this.serviceDescription = description }
        fun image(image: Drawable) = apply { this.serviceImage = image }
        fun build() = Service(serviceName!!,serviceDescription!!,serviceImage!!)
    }
    fun getAll(context: Context): ArrayList<Service>{
        val library = Builder()
            .name("Könytár")
            .description("Jó könyvek")
            .image(ResourcesCompat.getDrawable(context.resources, R.drawable.vector_services,null)!!)
            .build()
        val pharmacy = Builder()
            .name("Patika")
            .description("Jó könyvek")
            .image(ResourcesCompat.getDrawable(context.resources, R.drawable.vector_services,null)!!)
            .build()
        val doctor = Builder()
            .name("Orvosi Rendelő")
            .description("Jó könyvek")
            .image(ResourcesCompat.getDrawable(context.resources, R.drawable.vector_services,null)!!)
            .build()
        val dentist = Builder()
            .name("Fogorvos")
            .description("Jó könyvek")
            .image(ResourcesCompat.getDrawable(context.resources, R.drawable.vector_services,null)!!)
            .build()
        return arrayListOf(library,pharmacy,doctor,dentist)
    }

    override fun getCategory(context: Context): String {
        return context.getString(R.string.category_services )
    }
}