package com.example.kismadrapp.models

import android.graphics.drawable.Drawable

class Town(
    val name: String,
    val description: String,
    val distance: Double,
    val sights: List<Sight>,
    val images: List<Drawable>
) : CategoryModel() {
    override val categoryModelNam: String
        get() = this.name
    override val coverImage: Drawable
        get() = this.images[0]
    override val imageList: List<Drawable>?
        get() = images

}