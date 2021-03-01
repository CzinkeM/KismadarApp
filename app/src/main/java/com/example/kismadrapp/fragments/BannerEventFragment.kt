package com.example.kismadrapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kismadrapp.R
import com.example.kismadrapp.databinding.FragmentBannerEventBinding
import com.example.kismadrapp.models.Banner
import com.example.kismadrapp.viewmodels.BannerViewModel


class BannerEventFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentBannerEventBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_banner_event, container, false)
        val viewModel = ViewModelProvider(this).get(BannerViewModel::class.java)
        binding.banner = Banner(
            resources.getString(R.string.banner_discover),
            binding.bannerEventBackground.drawable,
            viewModel.getColorsOfImage(binding.bannerEventBackground.drawable),
            viewModel.getRecentEvent()
        )
        return binding.root
    }
}