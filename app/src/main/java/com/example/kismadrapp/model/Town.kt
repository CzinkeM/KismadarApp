package com.example.kismadrapp.model

import android.graphics.drawable.Drawable
import com.example.kismadrapp.list.Sight

class Town(
        val name: String,
        val description: String,
        val distance: Double,
        val sights :List<Sight>,
        val img: List<Drawable>
):CategoryModel() {
        override val categoryModelNam: String
                get() = this.name
        override val coverImage: Drawable
                get() = this.img[0]
        override val imageList: List<Drawable>?
                get() = img

}