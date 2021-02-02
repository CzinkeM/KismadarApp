package com.example.kismadrapp.banner

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.kismadrapp.R
import com.example.kismadrapp.databinding.FragmentBannerEventBinding
import com.example.kismadrapp.model.Banner
import kotlin.math.abs


class BannerEventFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentBannerEventBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_banner_event, container, false)
        val viewModelFactory = BannerViewModelFactory(resources)
        val viewModel = ViewModelProvider(this,viewModelFactory).get(BannerViewModel::class.java)
        val generatedImage = viewModel.getRandomTownImage()
        binding.banner = Banner(resources.getString(R.string.banner_discover),generatedImage,viewModel.getColorsOfImage(generatedImage),viewModel.getRecentEvent())

        return binding.root
    }

}