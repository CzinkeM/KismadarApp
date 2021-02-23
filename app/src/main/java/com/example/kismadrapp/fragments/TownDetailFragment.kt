package com.example.kismadrapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kismadrapp.R
import com.example.kismadrapp.databinding.FragmentDetailsTownBinding

class TownDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentDetailsTownBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_details_town, container, false)
        binding.buttonBackTown.setOnClickListener {
            findNavController().navigate(TownDetailFragmentDirections.actionTownDetailFragmentToWelcomePageFragment())
        }
        return binding.root
    }
}