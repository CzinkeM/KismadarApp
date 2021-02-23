package com.example.kismadrapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kismadrapp.*
import com.example.kismadrapp.activities.WelcomeActivity
import com.example.kismadrapp.databinding.FragmentPageWelcomeBinding
import com.example.kismadrapp.models.*
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

        binding.foodRecyclerView.categoryRecyclerView.layoutManager =
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

        binding.foodRecyclerView.categoryRecyclerView.adapter = CategoryAdapter(
            CategoryClickListener {
                Toast.makeText(context, it.categoryModelNam, Toast.LENGTH_SHORT).show()
                findNavController().navigate(WelcomePageFragmentDirections.welcomePageFragmentToRestaurantDetailFragment())
            }, getRestaurants(resources)
        )
        binding.serviceRecyclerView.categoryRecyclerView.adapter = CategoryAdapter(
            CategoryClickListener {
                Toast.makeText(context, it.categoryModelNam, Toast.LENGTH_SHORT).show()
                findNavController().navigate(WelcomePageFragmentDirections.welcomePageFragmentToServiceDetailFragment())
            }, getServices(resources)
        )
        binding.shopRecyclerView.categoryRecyclerView.adapter = CategoryAdapter(
            CategoryClickListener {
                Toast.makeText(context, it.categoryModelNam, Toast.LENGTH_SHORT).show()
                findNavController().navigate(WelcomePageFragmentDirections.welcomePageFragmentToShopDetailFragment())
            }, getShops(resources)
        )
        binding.sightRecyclerView.categoryRecyclerView.adapter = CategoryAdapter(
            CategoryClickListener {
                Toast.makeText(context, it.categoryModelNam, Toast.LENGTH_SHORT).show()
                findNavController().navigate(WelcomePageFragmentDirections.welcomePageFragmentToSightDetailFragment())
            }, getSights(resources)
        )
        binding.natureRecyclerView.categoryRecyclerView.adapter = CategoryAdapter(
            CategoryClickListener {
                Toast.makeText(context, it.categoryModelNam, Toast.LENGTH_SHORT).show()
                findNavController().navigate(
                    WelcomePageFragmentDirections.welcomePageFragmentToNatureDetailsFragment(
                        it.categoryModelNam
                    )
                )
            }, getNatureSights(resources)
        )
        binding.townRecyclerView.categoryRecyclerView.adapter = TownAdapter(
            CategoryClickListener {
                Toast.makeText(context, it.categoryModelNam, Toast.LENGTH_SHORT).show()
                findNavController().navigate(WelcomePageFragmentDirections.welcomePageFragmentToTownDetailFragment())
            }, getTowns(resources)
        )

        binding.viewFlipper.isAutoStart = true
        binding.drawerButton.setOnClickListener {
            val act = activity as WelcomeActivity
            act.openDrawer()
        }
        return binding.root
    }

    private fun chooseCategory(id: String) {
        findNavController().navigate(
            WelcomePageFragmentDirections.welcomePageFragmentToListActivity(
                id
            )
        )
    }
}