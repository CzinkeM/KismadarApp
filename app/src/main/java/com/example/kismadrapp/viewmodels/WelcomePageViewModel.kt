package com.example.kismadrapp.viewmodels

import android.content.Context
import android.content.res.Resources
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kismadrapp.R
import com.example.kismadrapp.databinding.LayoutCategoryBinding
import com.example.kismadrapp.models.NatureSight
import com.example.kismadrapp.models.Sight
import com.example.kismadrapp.utils.adapters.CategoryAdapter
import com.example.kismadrapp.utils.adapters.CategoryClickListener
import com.example.kismadrapp.utils.clicklisteners.TextClickListener

class WelcomePageViewModel(context: Context) : ViewModel() {
    fun setupRecyclerView(context: Context,layoutCategoryBinding: LayoutCategoryBinding, natureSight: NatureSight){
        layoutCategoryBinding.category = natureSight.getCategory(context)
        layoutCategoryBinding.categoryClickListener = TextClickListener {
            Toast.makeText(context,"Navigate to ${natureSight.getCategory(context)} list", Toast.LENGTH_SHORT).show()
        }
        layoutCategoryBinding.categoryRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        layoutCategoryBinding.categoryRecyclerView.adapter = CategoryAdapter(
            CategoryClickListener {
                Toast.makeText(context, it.locationName, Toast.LENGTH_SHORT).show()
                //ide kell a sheet megnyitás
            }, natureSight.getAll(context)
        )
    }
    fun setupRecyclerView(context: Context,layoutCategoryBinding: LayoutCategoryBinding, sight: Sight){
        layoutCategoryBinding.category = sight.getCategory(context)
        layoutCategoryBinding.categoryClickListener = TextClickListener {
            Toast.makeText(context,"Navigate to ${sight.getCategory(context)} list", Toast.LENGTH_SHORT).show()
        }
        layoutCategoryBinding.categoryRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        layoutCategoryBinding.categoryRecyclerView.adapter = CategoryAdapter(
            CategoryClickListener {
                Toast.makeText(context, it.locationName, Toast.LENGTH_SHORT).show()
                //ide kell a sheet megnyitás
            }, sight.getAll(context)
        )
    }

}