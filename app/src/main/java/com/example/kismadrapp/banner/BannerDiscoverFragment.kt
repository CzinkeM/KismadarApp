package com.example.kismadrapp.banner

import android.os.Bundle
import android.os.CountDownTimer
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
        timer().start()
        val binding: FragmentBannerDiscoverBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_banner_discover, container, false)
        val viewModel = ViewModelProvider(this).get(BannerViewModel::class.java)
        binding.banner = Banner(resources.getString(R.string.banner_discover),viewModel.getImage(resources),viewModel.getColorsOfImage(viewModel.getImage(resources)))
        binding.bannerDiscoverCardView.setOnClickListener{
            findNavController().navigate(R.id.action_bannerFragment_to_bannerEventFragment)
        }
        return binding.root
    }
    private fun timer(): CountDownTimer {
        return object : CountDownTimer(10000,1000){
            override fun onFinish() {
                findNavController().navigate(R.id.action_bannerFragment_to_bannerEventFragment)
            }
            override fun onTick(millisUntilFinished: Long) {
            }
        }
    }
}