package com.example.kismadrapp.viewmodels

import android.content.Context
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kismadrapp.NatureType
import com.example.kismadrapp.Pricing
import com.example.kismadrapp.R
import com.example.kismadrapp.getTowns
import com.example.kismadrapp.models.*
import com.example.kismadrapp.utils.adapters.CategoryAdapter
import com.example.kismadrapp.utils.adapters.CategoryClickListener

class ListViewModel(context: Context, fragmentManager: FragmentManager) : ViewModel() {
    private val viewModelContext = context
    private val viewModelFragmentManager = fragmentManager

    private val tag = "myTag"

    private val imgRestaurant =
        ResourcesCompat.getDrawable(context.resources, R.drawable.vector_food, null)!!
    private val imgNature =
        ResourcesCompat.getDrawable(context.resources, R.drawable.vector_trip, null)!!
    private val imgService =
        ResourcesCompat.getDrawable(context.resources, R.drawable.vector_services, null)!!
    private val imgShop =
        ResourcesCompat.getDrawable(context.resources, R.drawable.vector_shop, null)!!
    private val imgSight =
        ResourcesCompat.getDrawable(context.resources, R.drawable.vector_travellers, null)!!

    //Models
    private val testRestaurant = Restaurant(
        "Test Restaurant", "Test Street 32",
        Pricing.MODERATE, imgRestaurant, null
    )
    private val testNature = Nature(
        "Tast ViewPoint",
        NatureType.VIEWPOINT, "Ez egy leírás", imgNature, null
    )
    private val testService =
        Service("Test Service", "Test Service's description", imgService, null)
    private val testShop = Shop("Test Shop", imgShop, null)
    private val testSight = Sight("Test Sight", "This is good sight", true, imgSight, null)

    //Lists
    private val restaurantList = arrayListOf<CategoryModel>(
        testRestaurant,
        testRestaurant,
        testRestaurant,
        testRestaurant,
        testRestaurant,
        testRestaurant,
        testRestaurant,
        testRestaurant,
        testRestaurant
    )
    private val natureList = arrayListOf<CategoryModel>(
        testNature,
        testNature,
        testNature,
        testNature,
        testNature,
        testNature,
        testNature
    )
    private val serviceList = arrayListOf<CategoryModel>(
        testService,
        testService,
        testService,
        testService,
        testService,
        testService,
        testService,
        testService,
        testService
    )
    private val shopList = arrayListOf<CategoryModel>(
        testShop,
        testShop,
        testShop,
        testShop,
        testShop,
        testShop,
        testShop,
        testShop,
        testShop,
        testShop,
        testShop,
        testShop,
        testShop
    )
    private val sightList = arrayListOf<CategoryModel>(
        testSight,
        testSight,
        testSight,
        testSight,
        testSight,
        testSight,
        testSight,
        testSight,
        testSight,
        testSight,
        testSight,
        testSight
    )

    fun setAdapter(categoryName: String): RecyclerView.Adapter<RecyclerView.ViewHolder> {
        val adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>
        var list = ArrayList<CategoryModel>()
        when (categoryName) {
            viewModelContext.getString(R.string.category_food_drink) -> list = restaurantList
            viewModelContext.getString(R.string.category_nature) -> list = natureList
            viewModelContext.getString(R.string.category_surroundings) -> list =
                getTowns(viewModelContext.resources) as ArrayList<CategoryModel>
            viewModelContext.getString(R.string.category_shops) -> list = shopList
            viewModelContext.getString(R.string.category_services) -> list = serviceList
            viewModelContext.getString(R.string.category_sights) -> list = sightList
        }
        //Vertikális
        adapter = CategoryAdapter(CategoryClickListener {
            //specifikusan it-et vizsgálva
        }, list)
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

    fun setBackground(categoryName: String): Int {
        return when (categoryName) {
            else -> R.drawable.shape_header
        }
    }
}