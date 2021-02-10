package com.example.kismadrapp.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kismadrapp.databinding.ItemRestaurantBinding

class RestaurantAdapter(
    private val clickListener: RestaurantClickListener,
    private val values: List<Restaurant>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                val item = values[position]
                holder.bind(item, clickListener)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val binding: ItemRestaurantBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Restaurant, clickListener: RestaurantClickListener) {
            binding.restaurant = item
            binding.restaurantClickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemRestaurantBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return values.size
    }
}

class RestaurantClickListener(val clickListener: (restaurantId: String) -> Unit) {
    fun onClick(restaurant: Restaurant) = clickListener(restaurant.resName)
}