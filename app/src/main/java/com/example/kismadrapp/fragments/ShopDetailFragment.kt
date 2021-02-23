package com.example.kismadrapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kismadrapp.R
import com.example.kismadrapp.databinding.FragmentDetailShopBinding

class ShopDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentDetailShopBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail_shop, container, false)
        binding.buttonBackShop.setOnClickListener {
            findNavController().navigate(ShopDetailFragmentDirections.shopDetailFragmentToWelcomePageFragment())
        }
        return binding.root
    }
}