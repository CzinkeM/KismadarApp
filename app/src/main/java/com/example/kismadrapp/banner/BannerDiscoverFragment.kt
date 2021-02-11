package com.example.kismadrapp.banner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.kismadrapp.R
import com.example.kismadrapp.databinding.FragmentBannerDiscoverBinding
import com.example.kismadrapp.model.Banner
import java.util.*
import kotlin.concurrent.schedule

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