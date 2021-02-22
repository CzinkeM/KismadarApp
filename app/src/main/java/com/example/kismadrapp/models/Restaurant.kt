package com.example.kismadrapp.models

import android.graphics.drawable.Drawable
import com.example.kismadrapp.Pricing

class Restaurant(
    val resName: String,
    val description: String,
    val price: Pricing,
    val mainImage: Drawable,
    val images: List<Drawable>?
) : CategoryModel() {
    override val categoryModelNam: String
        get() = this.resName
    override val coverImage: Drawable
        get() = this.mainImage
    override val imageList: List<Drawable>?
        get() = this.images

}