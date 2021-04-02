package com.example.kismadrapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kismadrapp.*
import com.example.kismadrapp.activities.WelcomeActivity
import com.example.kismadrapp.databinding.FragmentPageWelcomeBinding
import com.example.kismadrapp.databinding.LayoutCategoryBinding
import com.example.kismadrapp.models.NatureSight
import com.example.kismadrapp.models.RecyclerViewSetter
import com.example.kismadrapp.models.Sight
import com.example.kismadrapp.models.Town
import com.example.kismadrapp.viewmodels.WelcomePageViewModel

class WelcomePageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentPageWelcomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_page_welcome, container, false)
        val viewModel = ViewModelProvider(this).get(WelcomePageViewModel::class.java)
        binding.viewModel = viewModel

        RecyclerViewSetter(context!!,binding.natureRecyclerView).natureSight(
            viewModel.itemClickListener(context!!),
            viewModel.textClickListener(context!!)
        )
        RecyclerViewSetter(context!!,binding.sightRecyclerView).sight(
            viewModel.itemClickListener(context!!),
            viewModel.textClickListener(context!!)
        )
        RecyclerViewSetter(context!!,binding.restaurantRecyclerView).restaurant(
            viewModel.itemClickListener(context!!),
            viewModel.textClickListener(context!!)
        )
        RecyclerViewSetter(context!!,binding.shopRecyclerView).shop(
            viewModel.itemClickListener(context!!),
            viewModel.textClickListener(context!!)
        )
        RecyclerViewSetter(context!!,binding.serviceRecyclerView).service(
            viewModel.itemClickListener(context!!),
            viewModel.textClickListener(context!!)
        )
        RecyclerViewSetter(context!!,binding.townRecyclerView).town(
            viewModel.itemClickListener(context!!),
            viewModel.textClickListener(context!!)
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