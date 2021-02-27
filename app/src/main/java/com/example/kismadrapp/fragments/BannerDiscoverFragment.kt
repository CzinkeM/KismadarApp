package com.example.kismadrapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kismadrapp.R
import com.example.kismadrapp.databinding.FragmentBannerDiscoverBinding
import com.example.kismadrapp.models.Banner
import com.example.kismadrapp.utils.viewmodelfactories.BannerViewModelFactory
import com.example.kismadrapp.viewmodels.BannerViewModel

class BannerDiscoverFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentBannerDiscoverBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_banner_discover, container, false)
        val viewModelFactory = BannerViewModelFactory(resources)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(BannerViewModel::class.java)
        binding.banner = Banner(
            resources.getString(R.string.banner_discover),
            binding.bannerDiscoverBackground.drawable,
            viewModel.getColorsOfImage(binding.bannerDiscoverBackground.drawable),
            null
        )
        return binding.root
    }
}