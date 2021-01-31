package com.example.kismadrapp.model

import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import com.example.kismadrapp.R

class Category(val id: Int, val icon: Drawable?,val title: String) {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}