package com.example.kismadrapp.models

import android.graphics.drawable.Drawable

abstract class CategoryModel {
    abstract val categoryModelNam: String
    abstract val coverImage: Drawable
    abstract val imageList: List<Drawable>?
}