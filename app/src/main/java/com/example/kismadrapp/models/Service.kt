package com.example.kismadrapp.models

import android.graphics.drawable.Drawable

class Service(
    val name: String,
    val description: String,
    val icon: Drawable,
    val images: List<Drawable>?
) : CategoryModel() {
    override val categoryModelName: String
        get() = this.name
    override val coverImage: Drawable
        get() = this.icon
    override val imageList: List<Drawable>?
        get() = this.images

}