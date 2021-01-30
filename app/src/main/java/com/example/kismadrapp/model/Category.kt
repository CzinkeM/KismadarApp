package com.example.kismadrapp.model

import android.graphics.drawable.Drawable

class Category(val id: Int, val icon: Drawable,val title: String) {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}