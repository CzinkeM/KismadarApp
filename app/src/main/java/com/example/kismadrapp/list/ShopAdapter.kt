package com.example.kismadrapp.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kismadrapp.databinding.ItemRestaurantBinding
import com.example.kismadrapp.databinding.ItemServiceBinding
import com.example.kismadrapp.databinding.ItemShopBinding

class ShopAdapter(
    private val clickListener: ShopClickListener,
    private val values: List<Shop>
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

    class ViewHolder private constructor(private val binding: ItemShopBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Shop, clickListener: ShopClickListener) {
            binding.shop = item
            binding.shopClickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemShopBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return values.size
    }
}

class ShopClickListener(val clickListener: (shopId: String) -> Unit) {
    fun onClick(shop: Shop) = clickListener(shop.name)
}