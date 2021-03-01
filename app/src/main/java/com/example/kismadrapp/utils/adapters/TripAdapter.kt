package com.example.kismadrapp.utils.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kismadrapp.databinding.ItemCategoryBinding
import com.example.kismadrapp.databinding.ItemCategoryTownBinding
import com.example.kismadrapp.databinding.ItemTripBinding
import com.example.kismadrapp.models.CategoryModel
import com.example.kismadrapp.models.Trip

class TripAdapter(
private val clickListener: TripClickListener,
private val values: List<Trip>
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

    class ViewHolder private constructor(private val binding: ItemTripBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Trip, clickListener: TripClickListener) {
            binding.trip = item
            binding.tripCliclListner = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemTripBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return values.size
    }
}

class TripClickListener(val clickListener: (id: Trip) -> Unit) {
    fun onClick(trip: Trip) = clickListener(trip)
}
