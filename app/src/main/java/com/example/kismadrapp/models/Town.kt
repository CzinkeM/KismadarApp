package com.example.kismadrapp.models

import android.graphics.drawable.Drawable

class Town(
    val townName: String,
    val townDescription: String,
    val townSight: List<Sight>,
    val townCoverImage: Drawable
) : Category(townName, townCoverImage) {
    override val type: CategoryType
        get() = CategoryType.Town
}