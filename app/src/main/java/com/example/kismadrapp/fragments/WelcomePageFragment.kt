package com.example.kismadrapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kismadrapp.*
import com.example.kismadrapp.activities.WelcomeActivity
import com.example.kismadrapp.databinding.FragmentPageWelcomeBinding
import com.example.kismadrapp.utils.*
import com.example.kismadrapp.utils.adapters.CategoryAdapter
import com.example.kismadrapp.utils.adapters.CategoryClickListener
import com.example.kismadrapp.utils.adapters.TownAdapter
import com.example.kismadrapp.utils.viewmodelfactories.WelcomePageViewModelFactory
import com.example.kismadrapp.viewmodels.WelcomePageViewModel

class WelcomePageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentPageWelcomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_page_welcome, container, false)
        val viewModelFactory = WelcomePageViewModelFactory(resources)
        val viewModel =
            ViewModelProvider(this, viewModelFactory).get(WelcomePageViewModel::class.java)
        binding.viewModel = viewModel
        binding.restaurantRecyclerView.categoryRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.serviceRecyclerView.categoryRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.shopRecyclerView.categoryRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.sightRecyclerView.categoryRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.natureRecyclerView.categoryRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.townRecyclerView.categoryRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        binding.natureRecyclerView.category = getCategoryNatureSight(resources)
        binding.sightRecyclerView.category = getCategorySight(resources)
        binding.serviceRecyclerView.category = getCategoryServices(resources)
        binding.restaurantRecyclerView.category = getCategoryFood(resources)
        binding.shopRecyclerView.category = getCategoryShop(resources)
        binding.townRecyclerView.category = getCategoryTowns(resources)

        binding.natureRecyclerView.categoryHeader.setOnClickListener {
            findNavController().navigate(WelcomePageFragmentDirections.welcomePageFragmentToListFragment(
                getCategoryNatureSight(resources).name))
        }
        binding.sightRecyclerView.categoryHeader.setOnClickListener {
            findNavController().navigate(WelcomePageFragmentDirections.welcomePageFragmentToListFragment(
                getCategorySight(resources).name)
            )
        }
        binding.serviceRecyclerView.categoryHeader.setOnClickListener {
            findNavController().navigate(WelcomePageFragmentDirections.welcomePageFragmentToListFragment(
                getCategoryServices(resources).name))
        }
        binding.restaurantRecyclerView.categoryHeader.setOnClickListener {
            findNavController().navigate(WelcomePageFragmentDirections.welcomePageFragmentToListFragment(
                getCategoryFood(resources).name))
        }
        binding.shopRecyclerView.categoryHeader.setOnClickListener {
            findNavController().navigate(WelcomePageFragmentDirections.welcomePageFragmentToListFragment(
                getCategoryShop(resources).name))
        }
        binding.townRecyclerView.categoryHeader.setOnClickListener {
            findNavController().navigate(WelcomePageFragmentDirections.welcomePageFragmentToListFragment(
                getCategoryTowns(resources).name))
        }


        binding.restaurantRecyclerView.categoryRecyclerView.adapter = CategoryAdapter(
            CategoryClickListener {
                findNavController().navigate(WelcomePageFragmentDirections.welcomePageFragmentToRestaurantDetailFragment(it.categoryModelName))
            }, getRestaurants(resources)
        )
        binding.serviceRecyclerView.categoryRecyclerView.adapter = CategoryAdapter(
            CategoryClickListener {
                findNavController().navigate(WelcomePageFragmentDirections.welcomePageFragmentToServiceDetailFragment(it.categoryModelName))
            }, getServices(resources)
        )
        binding.shopRecyclerView.categoryRecyclerView.adapter = CategoryAdapter(
            CategoryClickListener {
                findNavController().navigate(WelcomePageFragmentDirections.welcomePageFragmentToShopDetailFragment(it.categoryModelName))
            }, getShops(resources)
        )
        binding.sightRecyclerView.categoryRecyclerView.adapter = CategoryAdapter(
            CategoryClickListener {
                findNavController().navigate(WelcomePageFragmentDirections.welcomePageFragmentToSightDetailFragment(it.categoryModelName))
            }, getSights(resources)
        )
        binding.natureRecyclerView.categoryRecyclerView.adapter = CategoryAdapter(
            CategoryClickListener {
                Toast.makeText(context, it.categoryModelName, Toast.LENGTH_SHORT).show()
                findNavController().navigate(
                    WelcomePageFragmentDirections.welcomePageFragmentToNatureDetailsFragment(
                        it.categoryModelName
                    )
                )
            }, getNatureSights(resources)
        )
        binding.townRecyclerView.categoryRecyclerView.adapter = TownAdapter(
            CategoryClickListener {
                findNavController().navigate(WelcomePageFragmentDirections.welcomePageFragmentToTownDetailFragment(it.categoryModelName))
            }, getTowns(resources)
        )

        binding.viewFlipper.isAutoStart = true
        binding.drawerButton.setOnClickListener {
            val act = activity as WelcomeActivity
            act.openDrawer()
        }
        val activity = activity as WelcomeActivity
        activity.weather.observe(viewLifecycleOwner, Observer {
            binding.weatherFragment.weather = it
            Log.i("weather","temperature: ${it.temp}, status: ${it.weatherStatus}")
        })
        activity.isLoading.observe(viewLifecycleOwner, Observer {
            binding.weatherProgressBar.isVisible = it
        })

        return binding.root
    }

    fun chooseCategory(id: String) {
        findNavController().navigate(
            WelcomePageFragmentDirections.welcomePageFragmentToListFragment(
                id
            )
        )
    }
}