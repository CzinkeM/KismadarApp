package com.example.kismadrapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.kismadrapp.R
import com.example.kismadrapp.databinding.FragmentDetailShopBinding
import com.example.kismadrapp.databinding.FragmentDetailsSightBinding

class SightDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentDetailsSightBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_details_sight,container,false)
        binding.buttonBackSight.setOnClickListener {
            findNavController().navigate(SightDetailFragmentDirections.actionSightDetailFragmentToWelcomePageFragment())
        }
        return binding.root
    }
}