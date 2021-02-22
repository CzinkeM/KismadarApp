package com.example.kismadrapp.list

import android.graphics.drawable.Drawable
import com.example.kismadrapp.model.CategoryModel

class Service(val name: String, val description: String, val icon: Drawable, val images: List<Drawable>?): CategoryModel() {
    override val categoryModelNam: String
        get() = this.name
    override val coverImage: Drawable
        get() = this.icon
    override val imageList: List<Drawable>?
        get() = this.images

}