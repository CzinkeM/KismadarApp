package com.example.kismadrapp.database

import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kismadrapp.R

@Entity(tableName = "categories_table")
class Category(
        @PrimaryKey(autoGenerate = true)
        var id: Int,
        @ColumnInfo(name = "category_icon")
        val icon: Drawable?,
        @ColumnInfo(name = "category_name")
        val name: String)
{
}