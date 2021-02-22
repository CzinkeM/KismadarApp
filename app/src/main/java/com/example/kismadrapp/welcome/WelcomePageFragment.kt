package com.example.kismadrapp.welcome

import android.os.Bundle
import android.provider.ContactsContract
import android.text.Layout
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.Button
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.GravityCompat
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kismadrapp.R
import com.example.kismadrapp.WelcomeActivity
import com.example.kismadrapp.databinding.FragmentPageWelcomeBinding
import com.example.kismadrapp.databinding.LayoutWelcomeBinding
import com.example.kismadrapp.list.*
import com.example.kismadrapp.model.Category
import com.example.kismadrapp.utils.EmbeddedValues

class WelcomePageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentPageWelcomeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_page_welcome,container,false)
        val viewModelFactory = WelcomePageViewModelFactory(resources)
        val viewModel = ViewModelProvider(this,viewModelFactory).get(WelcomePageViewModel::class.java)
        binding.viewModel = viewModel
        val data = EmbeddedValues(resources)

        val imgRestaurant = ResourcesCompat.getDrawable(context!!.resources,R.drawable.art_vector_food,null)!!
        val imgNature = ResourcesCompat.getDrawable(context!!.resources,R.drawable.art_vector_trip,null)!!
        val imgService = ResourcesCompat.getDrawable(context!!.resources,R.drawable.art_vector_services,null)!!
        val imgShop = ResourcesCompat.getDrawable(context!!.resources,R.drawable.art_vector_shop,null)!!
        val imgSight = ResourcesCompat.getDrawable(context!!.resources,R.drawable.art_vector_travellers,null)!!
        //Models
        val testRestaurant = Restaurant("Test Restaurant", "Test Street 32", "A legjobb éttereme a vidéken",
            Pricing.MODERATE,imgRestaurant,null)
        val testNature = Nature("Tast ViewPoint",NatureType.VIEWPOINT,"Ez egy leírás",imgNature,null)
        val testService = Service("Test Service","Test Service's description",imgService,null)
        val testShop = Shop("Test Shop","Test Street 30.",imgShop,null)
        val testSight = Sight("Test Sight","This is good sight",true,imgSight,null)
        //Lists
        val restaurantList = listOf(testRestaurant,testRestaurant,testRestaurant,testRestaurant,testRestaurant,testRestaurant,testRestaurant,testRestaurant,testRestaurant)
        val natureList = listOf(testNature,testNature,testNature,testNature,testNature,testNature,testNature)
        val serviceList = listOf(testService,testService,testService,testService,testService,testService,testService,testService,testService)
        val shopList = listOf(testShop,testShop,testShop,testShop,testShop,testShop,testShop,testShop,testShop,testShop,testShop,testShop,testShop)
        val sightList = listOf(testSight,testSight,testSight,testSight,testSight,testSight,testSight,testSight,testSight,testSight,testSight,testSight)


        val categoryList = data.generateCategoryList(resources)
        binding.foodRecyclerView.category = categoryList[0]
        binding.serviceRecyclerView.category = categoryList[1]
        binding.shopRecyclerView.category = categoryList[2]
        binding.sightRecyclerView.category = categoryList[3]
        binding.natureRecyclerView.category = categoryList[4]
        binding.townRecyclerView.category = categoryList[5]

        binding.foodRecyclerView.categoryRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.serviceRecyclerView.categoryRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.shopRecyclerView.categoryRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.sightRecyclerView.categoryRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.natureRecyclerView.categoryRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.townRecyclerView.categoryRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        binding.foodRecyclerView.categoryRecyclerView.adapter = CategoryAdapter(CategoryClickListener {
            Toast.makeText(context,it.categoryModelNam,Toast.LENGTH_SHORT).show()
        },restaurantList)
        binding.serviceRecyclerView.categoryRecyclerView.adapter = CategoryAdapter(CategoryClickListener {
            Toast.makeText(context,it.categoryModelNam,Toast.LENGTH_SHORT).show()

        },serviceList)
        binding.shopRecyclerView.categoryRecyclerView.adapter = CategoryAdapter(CategoryClickListener {
            Toast.makeText(context,it.categoryModelNam,Toast.LENGTH_SHORT).show()

        },shopList)
        binding.sightRecyclerView.categoryRecyclerView.adapter = CategoryAdapter(CategoryClickListener {
            Toast.makeText(context,it.categoryModelNam,Toast.LENGTH_SHORT).show()

        },sightList)
        binding.natureRecyclerView.categoryRecyclerView.adapter = CategoryAdapter(CategoryClickListener {
            Toast.makeText(context,it.categoryModelNam,Toast.LENGTH_SHORT).show()

        },natureList)
        binding.townRecyclerView.categoryRecyclerView.adapter = CategoryAdapter(CategoryClickListener {
            Toast.makeText(context,it.categoryModelNam,Toast.LENGTH_SHORT).show()

        },data.listOfTowns)

        binding.viewFlipper.isAutoStart = true
        binding.drawerButton.setOnClickListener {
            val act = activity as WelcomeActivity
            act.openDrawer()
        }
        return binding.root
    }
    private fun chooseCategory(id: String){
        findNavController().navigate(WelcomePageFragmentDirections.actionWelcomePageFragmentToListActivity(id))
    }
}