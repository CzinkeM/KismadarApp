package com.example.kismadrapp.models

import android.graphics.drawable.Drawable

abstract class Category(val name: String, val cover: Drawable) {
    abstract val type: CategoryType
}