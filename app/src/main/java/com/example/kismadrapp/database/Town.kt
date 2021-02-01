package com.example.kismadrapp.database

import android.graphics.drawable.Drawable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "town_table")
class Town(
        @PrimaryKey(autoGenerate = true)
        var id: Int,
        @ColumnInfo(name = "town_name")
        val name: String,
        @ColumnInfo(name = "town_image")
        val img: Drawable?
) {
}