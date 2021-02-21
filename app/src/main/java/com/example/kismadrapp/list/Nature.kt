package com.example.kismadrapp.list

import android.graphics.drawable.Drawable
import com.example.kismadrapp.model.CategoryModel

enum class NatureType{LAKE,VIEWPOINT,SPRING,OTHER}
class Nature(val name: String, val type: NatureType, val description: String,val mainImage: Drawable,val images: List<Drawable>?): CategoryModel() {
    override val categoryModelNam: String
        get() = this.name
    override val coverImage: Drawable
        get() = this.mainImage
    override val imageList: List<Drawable>?
        get() = this.images

}