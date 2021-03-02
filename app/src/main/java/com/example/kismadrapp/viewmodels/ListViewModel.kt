package com.example.kismadrapp.viewmodels

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kismadrapp.*
import com.example.kismadrapp.models.CategoryType
import com.example.kismadrapp.utils.*
import com.example.kismadrapp.utils.adapters.CategoryClickListener
import com.example.kismadrapp.utils.adapters.CategoryVerticalAdapter

class ListViewModel(context: Context) : ViewModel() {
    private val viewModelContext = context

    fun setAdapter(categoryName: String): RecyclerView.Adapter<RecyclerView.ViewHolder> {
        val adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>
        when (categoryName) {
            CategoryType.FoodAndDrink.name -> adapter = CategoryVerticalAdapter(
                CategoryClickListener {

            }, getRestaurants(viewModelContext.resources)
            )
            CategoryType.NatureSight.name-> adapter = CategoryVerticalAdapter(
                CategoryClickListener {

                }, getNatureSights(viewModelContext.resources)
            )
            CategoryType.Town.name -> adapter = CategoryVerticalAdapter(
                CategoryClickListener {

                }, getTowns(viewModelContext.resources)
            )
            CategoryType.Shop.name -> adapter = CategoryVerticalAdapter(
                CategoryClickListener {

                }, getShops(viewModelContext.resources)
            )
            CategoryType.Service.name -> adapter = CategoryVerticalAdapter(
                CategoryClickListener {

                }, getServices(viewModelContext.resources)
            )
            CategoryType.Sight.name -> adapter = CategoryVerticalAdapter(
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