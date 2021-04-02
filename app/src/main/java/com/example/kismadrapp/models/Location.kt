package com.example.kismadrapp.models

import android.content.Context
import android.graphics.drawable.Drawable


abstract class Location(
    var locationName:String?,
    var locationImage: Drawable?) {
    abstract fun getCategory(context: Context): String
    abstract fun equalsToLocation(location: Location): Boolean
}