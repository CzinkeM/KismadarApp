package com.example.kismadrapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kismadrapp.R
import com.example.kismadrapp.databinding.FragmentDetailRestaurantBinding

class RestaurantDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentDetailRestaurantBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail_restaurant, container, false)
        binding.buttonBackRestaurant.setOnClickListener {
            findNavController().navigate(RestaurantDetailFragmentDirections.restaurantDetailFragmentToWelcomePageFragment())
        }
        return binding.root
    }
}