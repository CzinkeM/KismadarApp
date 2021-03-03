package com.example.kismadrapp.models

import android.graphics.drawable.Drawable

class Shop(val shopName: String, val shopCoverImage: Drawable) :
    Category(shopName,shopCoverImage) {
    override val type: CategoryType
        get() = CategoryType.Shop

    override fun getAll(): Collection<Category> {
        TODO("Not yet implemented")
    }
}