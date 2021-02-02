package com.example.kismadrapp.banner

import android.os.Bundle
import android.os.CountDownTimer
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
        timer().start()
        val binding: FragmentBannerEventBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_banner_event, container, false)
        val viewModel = ViewModelProvider(this).get(BannerViewModel::class.java)
        binding.banner = Banner(resources.getString(R.string.banner_discover),viewModel.getImage(resources),viewModel.getColorsOfImage(viewModel.getImage(resources)))
        binding.bannerEventCardView.setOnClickListener{
            findNavController().navigate(R.id.action_bannerEventFragment_to_bannerFragment)
        }
        return binding.root
    }
    private fun timer(): CountDownTimer{
        return object : CountDownTimer(10000,1000){
            override fun onFinish() {
                findNavController().navigate(R.id.action_bannerEventFragment_to_bannerFragment)
            }
            override fun onTick(millisUntilFinished: Long) {
            }
        }
    }

}