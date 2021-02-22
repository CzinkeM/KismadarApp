package com.example.kismadrapp.model

import android.graphics.drawable.Drawable

class Category(
        val icon: Drawable?,
        val name: String): CategoryModel()
{
        override val categoryModelNam: String
                get() = this.name
        override val coverImage: Drawable
                get() = this.icon!! // lehet hogy nem kell ne adjon vissza semmit
        override val imageList: List<Drawable>?
                get() = TODO("Not yet implemented")
}