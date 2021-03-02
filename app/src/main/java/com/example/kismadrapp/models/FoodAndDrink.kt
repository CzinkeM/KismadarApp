package com.example.kismadrapp.models

import android.graphics.drawable.Drawable
import com.example.kismadrapp.utils.Pricing

class FoodAndDrink(
    val fadName: String,
    val fadDescription: String,
    val fadPrice: Pricing,
    val fadCoverImage: Drawable
) : Category(fadName,fadCoverImage) {
    override val type: CategoryType
        get() = CategoryType.FoodAndDrink
}