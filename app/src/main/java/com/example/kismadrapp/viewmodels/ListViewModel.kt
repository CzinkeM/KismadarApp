package com.example.kismadrapp.viewmodels

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kismadrapp.*
import com.example.kismadrapp.utils.*
import com.example.kismadrapp.utils.adapters.CategoryClickListener
import com.example.kismadrapp.utils.adapters.CategoryVerticalAdapter

class ListViewModel(context: Context) : ViewModel() {
    private val viewModelContext = context

    fun setAdapter(categoryName: String): RecyclerView.Adapter<RecyclerView.ViewHolder> {
        val adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>
        when (categoryName) {
            viewModelContext.getString(R.string.category_food_drink) -> adapter = CategoryVerticalAdapter(
                CategoryClickListener {

            }, getRestaurants(viewModelContext.resources)
            )
            viewModelContext.getString(R.string.category_nature) -> adapter = CategoryVerticalAdapter(
                CategoryClickListener {

                }, getNatureSights(viewModelContext.resources)
            )
            viewModelContext.getString(R.string.category_surroundings) -> adapter = CategoryVerticalAdapter(
                CategoryClickListener {

                }, getTowns(viewModelContext.resources)
            )
            viewModelContext.getString(R.string.category_shops) -> adapter = CategoryVerticalAdapter(
                CategoryClickListener {

                }, getShops(viewModelContext.resources)
            )
            viewModelContext.getString(R.string.category_services) -> adapter = CategoryVerticalAdapter(
                CategoryClickListener {

                }, getServices(viewModelContext.resources)
            )
            viewModelContext.getString(R.string.category_sights) -> adapter = CategoryVerticalAdapter(
                CategoryClickListener {

                }, getSights(viewModelContext.resources)
            )
            else -> adapter = CategoryVerticalAdapter(
                CategoryClickListener {

                }, getTowns(viewModelContext.resources)
            )
        }
        return adapter
    }

    fun setLayoutManager(categoryName: String): RecyclerView.LayoutManager {
        val layoutManager: RecyclerView.LayoutManager
        val linearLayout =
            LinearLayoutManager(viewModelContext, LinearLayoutManager.VERTICAL, false)
        val gridLayout = GridLayoutManager(viewModelContext, 2, RecyclerView.VERTICAL, false)
        layoutManager = when (categoryName) {
            viewModelContext.getString(R.string.category_nature) -> gridLayout
            viewModelContext.resources.getString(R.string.category_sights) -> gridLayout
            else -> linearLayout
        }
        return layoutManager
    }
}