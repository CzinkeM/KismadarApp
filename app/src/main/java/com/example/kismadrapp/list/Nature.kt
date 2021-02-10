package com.example.kismadrapp.list

import android.graphics.drawable.Drawable
enum class NatureType{LAKE,VIEWPOINT,SPRING,OTHER}
class Nature(val name: String, val type: NatureType, val description: String,val mainImage: Drawable,val images: List<Drawable>?) {
}