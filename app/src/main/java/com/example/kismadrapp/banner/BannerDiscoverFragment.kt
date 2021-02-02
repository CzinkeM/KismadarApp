package com.example.kismadrapp.banner

import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.kismadrapp.R
import com.example.kismadrapp.databinding.FragmentBannerDiscoverBinding
import com.example.kismadrapp.model.Banner

class BannerDiscoverFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding: FragmentBannerDiscoverBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_banner_discover, container, false)
        val viewModelFactory = BannerViewModelFactory(resources)
        val viewModel = ViewModelProvider(this,viewModelFactory).get(BannerViewModel::class.java)
        val generatedImage = viewModel.getRandomTownImage()
        binding.banner = Banner(resources.getString(R.string.banner_discover),generatedImage,viewModel.getColorsOfImage(generatedImage),null)

        return binding.root
    }

}