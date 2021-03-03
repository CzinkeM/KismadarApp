package com.example.kismadrapp.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.kismadrapp.R
import com.example.kismadrapp.models.NatureSight
import com.example.kismadrapp.models.FoodAndDrink
import com.example.kismadrapp.models.NatureSightType
import com.example.kismadrapp.models.Pricing

@BindingAdapter("PricingText")
fun TextView.setPricingText(item: FoodAndDrink) {
    text = when (item.fadPrice) {
        Pricing.CHEAP -> "$"
        Pricing.MODERATE -> "$$"
        Pricing.EXPENSIVE -> "$$$"
        Pricing.VERY_EXPENSIVE -> "$$$$"
    }
}

@BindingAdapter("natureIcon")
fun ImageView.setIcon(item: NatureSight) {
    setImageResource(
        when (item.natureSightType) {
            NatureSightType.OTHER -> R.drawable.ic_tree
            NatureSightType.SPRING -> R.drawable.ic_building
            NatureSightType.VIEWPOINT -> R.drawable.ic_map
            NatureSightType.LAKE -> R.drawable.ic_baseline_cloud_24
        }
    )
}
//Boltokhoz kategóriák !?