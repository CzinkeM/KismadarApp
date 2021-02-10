package com.example.kismadrapp.list

import android.content.Context
import android.content.res.Resources
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kismadrapp.R
import com.example.kismadrapp.model.EmbeddedValues
import com.example.kismadrapp.welcome.TownAdapter
import com.example.kismadrapp.welcome.TownClickListener

class ListViewModel(context: Context):ViewModel() {
    private val viewModelContext = context

    private val tag = "myTag"
    private val mainImage = ResourcesCompat.getDrawable(context.resources,R.mipmap.noszvaj_panorama_cut,null)!!
    private val data = EmbeddedValues(context.resources)
    //Models
    private val testRestaurant = Restaurant("Test Restaurant", "Test Street 32", "A legjobb éttereme a vidéken",Pricing.MODERATE,mainImage,null)
    private val testNature = Nature("Tast ViewPoint",NatureType.VIEWPOINT,"Ez egy leírás",mainImage,null)
    private val testService = Service("Test Service","Test Service's description",mainImage,null)
    private val testShop = Shop("Test Shop","Test Street 30.",mainImage,null)
    private val testSight = Sight("Test Sight","This is good sight",true,mainImage,null)
    //Lists
    private val restaurantList = listOf(testRestaurant,testRestaurant,testRestaurant,testRestaurant,testRestaurant,testRestaurant,testRestaurant,testRestaurant,testRestaurant)
    private val natureList = listOf(testNature,testNature,testNature,testNature,testNature,testNature,testNature)
    private val serviceList = listOf(testService,testService,testService,testService,testService,testService,testService,testService,testService)
    private val shopList = listOf(testShop,testShop,testShop,testShop,testShop,testShop,testShop,testShop,testShop,testShop,testShop,testShop,testShop)
    private val sightList = listOf(testSight,testSight,testSight,testSight,testSight,testSight,testSight,testSight,testSight,testSight,testSight,testSight)

    fun chooseAdapter(categoryName: String): RecyclerView.Adapter<RecyclerView.ViewHolder>
    {
        val adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>
        when(categoryName)
        {
            viewModelContext.getString(R.string.category_food_drink) -> adapter = RestaurantAdapter(
                RestaurantClickListener {
                    restaurantId -> Log.i(tag,restaurantId)
            },restaurantList)
            viewModelContext.getString(R.string.category_nature) -> adapter = NatureAdapter(
                NatureClickListener {
                natureId ->   Log.i(tag,natureId)
            },natureList)
            viewModelContext.getString(R.string.category_services) -> adapter = ServiceAdapter(
                ServiceClickListener {
                serviceId -> Log.i(tag,serviceId)
            },serviceList)
            viewModelContext.getString(R.string.category_shops) -> adapter = ShopAdapter(
                ShopClickListener {
                    shopId -> Log.i(tag,shopId)
                },shopList)
            viewModelContext.getString(R.string.category_sights) -> adapter = SightAdapter(
                SightClickListener {
                    sightId -> Log.i(tag,sightId)
                },sightList)
            viewModelContext.getString(R.string.category_surroundings) -> adapter = TownAdapterVertical(
                TownClickListener {
                    townId -> Log.i(tag,townId)
                },data.listOfTowns)
            else -> adapter = RestaurantAdapter(RestaurantClickListener {
                    restaurantId -> Log.i(tag,"restaurantId")
            },restaurantList)
        }
        return adapter
    }
    fun chooseLayoutManager(categoryName: String): RecyclerView.LayoutManager
    {
        val layoutManager: RecyclerView.LayoutManager
        val linearLayout = LinearLayoutManager(viewModelContext, LinearLayoutManager.HORIZONTAL,false)
        val gridLayout = GridLayoutManager(viewModelContext,2,RecyclerView.VERTICAL,false)
        layoutManager = when(categoryName) {
            viewModelContext.resources.getString(R.string.category_nature) -> gridLayout
            viewModelContext.resources.getString(R.string.category_sights) -> gridLayout
            else -> linearLayout
        }
        return layoutManager
    }
}