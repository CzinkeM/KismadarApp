package com.example.kismadrapp

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.kismadrapp.models.Nature
import com.example.kismadrapp.utils.NatureType

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