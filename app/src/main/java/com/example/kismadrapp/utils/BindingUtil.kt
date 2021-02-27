package com.example.kismadrapp

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.kismadrapp.models.Nature
import com.example.kismadrapp.models.Restaurant
import com.example.kismadrapp.utils.NatureType
import com.example.kismadrapp.utils.Pricing

@BindingAdapter("PricingText")
fun TextView.setPricingText(item: Restaurant) {
    text = when (item.price) {
        Pricing.CHEAP -> "$"
        Pricing.MODERATE -> "$$"
        Pricing.EXPENSIVE -> "$$$"
        Pricing.VEXPENSIVE -> "$$$$"
    }
}

@BindingAdapter("natureIcon")
fun ImageView.setIcon(item: Nature) {
    setImageResource(
        when (item.type) {
            NatureType.OTHER -> R.drawable.ic_tree
            NatureType.SPRING -> R.drawable.ic_building
            NatureType.VIEWPOINT -> R.drawable.ic_map
            NatureType.LAKE -> R.drawable.ic_baseline_cloud_24
        }
    )
}
//Boltokhoz kategóriák !?