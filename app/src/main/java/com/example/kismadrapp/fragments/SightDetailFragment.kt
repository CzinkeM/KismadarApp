package com.example.kismadrapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kismadrapp.R
import com.example.kismadrapp.databinding.FragmentDetailsSightBinding

class SightDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentDetailsSightBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_details_sight, container, false)
        binding.buttonBackSight.setOnClickListener {
            findNavController().navigate(SightDetailFragmentDirections.sightDetailFragmentToWelcomePageFragment())
        }
        return binding.root
    }
}