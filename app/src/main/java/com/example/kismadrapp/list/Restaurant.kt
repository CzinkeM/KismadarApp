package com.example.kismadrapp.list

import android.graphics.drawable.Drawable

enum class Pricing{CHEAP,MODERATE,EXPENSIVE, VEXPENSIVE}
class Restaurant(val resName: String,val address: String,val description: String,val price: Pricing , val mainImage: Drawable, val images: List<Drawable>?)