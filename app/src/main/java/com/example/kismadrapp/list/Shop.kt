package com.example.kismadrapp.list

import android.graphics.drawable.Drawable
import com.example.kismadrapp.model.CategoryModel

class Shop(val name:String, val address: String, val mainImage: Drawable, val images: List<Drawable>?): CategoryModel() {
    override val categoryModelNam: String
        get() = this.name
    override val coverImage: Drawable
        get() = this.mainImage
    override val imageList: List<Drawable>?
        get() = this.images
}