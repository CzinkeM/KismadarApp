package com.example.kismadrapp.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kismadrapp.*
import com.example.kismadrapp.utils.*
import com.example.kismadrapp.utils.adapters.CategoryClickListener

class ListViewModel(context: Context) : ViewModel() {
    private val viewModelContext = context

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