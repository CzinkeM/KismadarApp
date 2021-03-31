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

        binding.natureRecyclerView.categoryRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        binding.natureRecyclerView.category = getCategoryNatureSight(resources)

        binding.natureRecyclerView.categoryHeader.setOnClickListener {
            findNavController().navigate(WelcomePageFragmentDirections.welcomePageFragmentToListFragment(
                getCategoryNatureSight(resources).name))
        }

        binding.natureRecyclerView.categoryRecyclerView.adapter = CategoryAdapter(
            CategoryClickListener {
                Toast.makeText(context, it.categoryModelName, Toast.LENGTH_SHORT).show()
                //ide kell a sheet megnyitás
            }, getNatureSights(resources)
        )
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
}