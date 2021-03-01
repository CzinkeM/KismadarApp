package com.example.kismadrapp.models

import android.graphics.drawable.Drawable
import com.example.kismadrapp.utils.NatureType

class Nature(
    val name: String,
    val type: NatureType,
    val description: String,
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