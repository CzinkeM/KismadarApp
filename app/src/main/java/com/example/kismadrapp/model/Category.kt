package com.example.kismadrapp.model

import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kismadrapp.R

class Category(
        val icon: Drawable?,
        val name: String)
{
}