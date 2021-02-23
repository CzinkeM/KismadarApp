package com.example.kismadrapp.utils.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kismadrapp.databinding.ItemCategoryBinding
import com.example.kismadrapp.databinding.ItemCategoryTownBinding
import com.example.kismadrapp.models.CategoryModel

class TownAdapter(
    private val clickListener: CategoryClickListener,
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

    class ViewHolder private constructor(private val binding: ItemCategoryTownBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CategoryModel, clickListener: CategoryClickListener) {
            binding.category = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCategoryTownBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return values.size
    }
}