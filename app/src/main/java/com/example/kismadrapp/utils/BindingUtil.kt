package com.example.kismadrapp.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.kismadrapp.R
import com.example.kismadrapp.models.NatureSight
import com.example.kismadrapp.models.FoodAndDrink

@BindingAdapter("PricingText")
fun TextView.setPricingText(item: FoodAndDrink) {
    text = when (item.fadPrice) {
        Pricing.CHEAP -> "$"
        Pricing.MODERATE -> "$$"
        Pricing.EXPENSIVE -> "$$$"
        Pricing.VEXPENSIVE -> "$$$$"
    }
}

@BindingAdapter("natureIcon")
fun ImageView.setIcon(item: NatureSight) {
    setImageResource(
        when (item.natureType) {
            NatureType.OTHER -> R.drawable.ic_tree
            NatureType.SPRING -> R.drawable.ic_building
            NatureType.VIEWPOINT -> R.drawable.ic_map
            NatureType.LAKE -> R.drawable.ic_baseline_cloud_24
        }
    )
}
//Boltokhoz kategóriák !?