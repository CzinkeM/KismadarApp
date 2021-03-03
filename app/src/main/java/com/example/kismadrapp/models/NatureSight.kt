package com.example.kismadrapp.models

import android.graphics.drawable.Drawable

class NatureSight(
    val natureName: String,
    val natureSightType: NatureSightType,
    val description: String,
    val natureCoverImage: Drawable
) : Category(natureName,natureCoverImage) {
    override val type: CategoryType
        get() = CategoryType.NatureSight

    override fun getAll(): Collection<Category> {
        TODO("Not yet implemented")
    }
}