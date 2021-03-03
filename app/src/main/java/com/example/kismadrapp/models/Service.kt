package com.example.kismadrapp.models

import android.graphics.drawable.Drawable

class Service(
    val serviceName: String,
    val serviceDescription: String,
    val serviceCoverImage: Drawable
) : Category(serviceName,serviceCoverImage) {
    override val type: CategoryType
        get() = CategoryType.Service

    override fun getAll(): Collection<Category> {
        TODO("Not yet implemented")
    }
}