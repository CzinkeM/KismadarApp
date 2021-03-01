package com.example.kismadrapp.models

import android.graphics.drawable.Drawable

class Sight(
    val name: String,
    val description: String,
    val isPaid: Boolean,
    val mainImage: Drawable,
    val images: List<Drawable>?
) : CategoryModel() {
    override val categoryModelName: String
        get() = this.name
    override val coverImage: Drawable
        get() = this.mainImage
    override val imageList: List<Drawable>?
        get() = this.images
}