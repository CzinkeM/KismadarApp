package com.example.kismadrapp.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kismadrapp.databinding.ItemRestaurantBinding
import com.example.kismadrapp.databinding.ItemServiceBinding

class ServiceAdapter(
    private val clickListener: ServiceClickListener,
    private val values: List<Service>
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

    class ViewHolder private constructor(private val binding: ItemServiceBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Service, clickListener: ServiceClickListener) {
            binding.service = item
            binding.serviceClickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemServiceBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return values.size
    }
}

class ServiceClickListener(val clickListener: (serviceId: String) -> Unit) {
    fun onClick(service: Service) = clickListener(service.name)
}