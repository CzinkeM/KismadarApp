package com.example.kismadrapp.welcome

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kismadrapp.R
import com.example.kismadrapp.database.AppDatabase
import com.example.kismadrapp.databinding.FragmentNewsBannerBinding
import com.example.kismadrapp.databinding.FragmentPageWelcomeBinding
import com.example.kismadrapp.model.Banner
import kotlin.math.log

class WelcomePageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentPageWelcomeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_page_welcome,container,false)
        val application = requireNotNull(this.activity).application
        val townDataSource = AppDatabase.getInstance(application).townDao
        val categoryDataSource = AppDatabase.getInstance(application).categoryDao
        val viewModelFactory = WelcomePageViewModelFactory(context!!,townDataSource,categoryDataSource)
        val viewModel = ViewModelProvider(this,viewModelFactory).get(WelcomePageViewModel::class.java)
        val townList = viewModel.getTownList
        val categoryList = viewModel.getCategoryList
        val randomBannerImage = viewModel.getRandomImage(townList.map { town -> town.img}.toList())
        val dominantColor = viewModel.getColorsOfImage(randomBannerImage).colorDominant
        binding.newsBanner.banner = Banner(resources.getString(R.string.banner_discover),randomBannerImage,dominantColor)
        binding.viewModel = viewModel
        binding.recyclerCategory.layoutManager = GridLayoutManager(context,2,RecyclerView.VERTICAL,false)
        binding.recyclerTown.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        binding.recyclerTown.adapter = TownAdapter(TownClickListener {
            townId ->Toast.makeText(context,"Clicked $townId", Toast.LENGTH_SHORT).show()
        },townList)
        binding.recyclerCategory.adapter = CategoryAdapter(CategoryClickListener { categoryId ->
            Toast.makeText(context, "Clicked $categoryId", Toast.LENGTH_SHORT).show()
        }, categoryList)
        return binding.root
    }

}