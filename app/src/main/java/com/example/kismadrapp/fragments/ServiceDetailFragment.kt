package com.example.kismadrapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kismadrapp.R
import com.example.kismadrapp.databinding.FragmentDetailServiceBinding

class ServiceDetailFragment : Fragment() {
    private val args: ServiceDetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentDetailServiceBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail_service, container, false)
        binding.buttonBackService.setOnClickListener {
            findNavController().navigate(ServiceDetailFragmentDirections.serviceDetailFragmentToWelcomePageFragment())
        }
        return binding.root
    }
}