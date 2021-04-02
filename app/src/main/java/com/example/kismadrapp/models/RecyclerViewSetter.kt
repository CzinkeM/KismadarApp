package com.example.kismadrapp.models

import android.content.Context
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kismadrapp.databinding.LayoutCategoryBinding
import com.example.kismadrapp.utils.adapters.CategoryAdapter
import com.example.kismadrapp.utils.adapters.CategoryClickListener
import com.example.kismadrapp.utils.clicklisteners.TextClickListener

class RecyclerViewSetter(private val context: Context,
                         private val layoutCategoryBinding: LayoutCategoryBinding
) {
    fun sight(itemClickListener: CategoryClickListener, textClickListener: TextClickListener) = apply{ // TODO: 2021. 04. 02.  Clicllistenerek construktorba
        layoutCategoryBinding.category = Sight().getCategory(context)
        layoutCategoryBinding.categoryClickListener = textClickListener
        layoutCategoryBinding.categoryRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        layoutCategoryBinding.categoryRecyclerView.adapter = CategoryAdapter(itemClickListener, Sight().getAll(context)
        )
    }
    fun natureSight(itemClickListener: CategoryClickListener, textClickListener: TextClickListener) = apply{ // TODO: 2021. 04. 02.  Clicllistenerek construktorba
        layoutCategoryBinding.category = NatureSight().getCategory(context)
        layoutCategoryBinding.categoryClickListener = textClickListener
        layoutCategoryBinding.categoryRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        layoutCategoryBinding.categoryRecyclerView.adapter = CategoryAdapter(itemClickListener, NatureSight().getAll(context)
        )
    }
    fun restaurant(itemClickListener: CategoryClickListener, textClickListener: TextClickListener) = apply{
        layoutCategoryBinding.category = Restaurant().getCategory(context)
        layoutCategoryBinding.categoryClickListener = textClickListener
        layoutCategoryBinding.categoryRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        layoutCategoryBinding.categoryRecyclerView.adapter = CategoryAdapter(itemClickListener, Restaurant().getAll(context)
        )
    }
    fun shop(itemClickListener: CategoryClickListener, textClickListener: TextClickListener) = apply{
        layoutCategoryBinding.category = Shop().getCategory(context)
        layoutCategoryBinding.categoryClickListener = textClickListener
        layoutCategoryBinding.categoryRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        layoutCategoryBinding.categoryRecyclerView.adapter = CategoryAdapter(itemClickListener, Shop().getAll(context)
        )
    }
    fun service(itemClickListener: CategoryClickListener, textClickListener: TextClickListener) = apply{
        layoutCategoryBinding.category = Service().getCategory(context)
        layoutCategoryBinding.categoryClickListener = textClickListener
        layoutCategoryBinding.categoryRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        layoutCategoryBinding.categoryRecyclerView.adapter = CategoryAdapter(itemClickListener, Service().getAll(context)
        )
    }

    fun town(itemClickListener: CategoryClickListener, textClickListener: TextClickListener) = apply{
        layoutCategoryBinding.category = Town().getCategory(context)
        layoutCategoryBinding.categoryClickListener = textClickListener
        layoutCategoryBinding.categoryRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        layoutCategoryBinding.categoryRecyclerView.adapter = CategoryAdapter(itemClickListener, Town().getAll(context)
        )
    }

}