package com.example.kismadrapp.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kismadrapp.databinding.ItemServiceBinding
import com.example.kismadrapp.databinding.ItemShopBinding
import com.example.kismadrapp.databinding.ItemSightBinding

class SightAdapter(
    private val clickListener: SightClickListener,
    private val values: List<Sight>
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

    class ViewHolder private constructor(private val binding: ItemSightBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Sight, clickListener: SightClickListener) {
            binding.sight = item
            binding.sightClickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemSightBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return values.size
    }
}

class SightClickListener(val clickListener: (sightId: String) -> Unit) {
    fun onClick(sight: Sight) = clickListener(sight.name)
}