package com.example.kismadrapp.database

import android.graphics.drawable.Drawable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

class Town(
        val name: String,
        val img: Drawable?
) {
}