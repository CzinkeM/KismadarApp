package com.example.kismadrapp.models

import android.graphics.drawable.Drawable

class FoodAndDrink(
    val fadName: String,
    val fadDescription: String,
    val fadPrice: Pricing,
    val fadCoverImage: Drawable
) : Category(fadName,fadCoverImage) {
    override val type: CategoryType
        get() = CategoryType.FoodAndDrink

    override fun getAll(): Collection<Category> {
        TODO("Not yet implemented")
    }
}