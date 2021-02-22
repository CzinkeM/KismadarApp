package com.example.kismadrapp.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kismadrapp.databinding.ItemSightBinding
import com.example.kismadrapp.databinding.ItemTownBinding
import com.example.kismadrapp.model.CategoryModel
import com.example.kismadrapp.model.Town
import com.example.kismadrapp.welcome.TownClickListener

class TownAdapterVertical(
    private val clickListener: TownClickListener,
    private val values: List<CategoryModel>
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

    class ViewHolder private constructor(private val binding: ItemTownBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CategoryModel, clickListener: TownClickListener) {
            binding.category = item
            binding.townClickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemTownBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return values.size
    }
}