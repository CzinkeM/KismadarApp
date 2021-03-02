package com.example.kismadrapp.models

import android.graphics.drawable.Drawable
import com.example.kismadrapp.utils.NatureType

class NatureSight(
    val natureName: String,
    val natureType: NatureType,
    val description: String,
    val natureCoverImage: Drawable
) : Category(natureName,natureCoverImage) {
    override val type: CategoryType
        get() = CategoryType.NatureSight
}