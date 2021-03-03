package com.example.kismadrapp.models

import android.graphics.drawable.Drawable

data class Sight(
    val sightName: String,
    val sightDescription: String,
    val sightTicketRequired: Boolean,
    val sightCoverImage: Drawable
) : Category(sightName,sightCoverImage) {
    override val type: CategoryType
        get() = CategoryType.Sight

    override fun getAll(): Collection<Category> {
        TODO("Not yet implemented")
    }
}