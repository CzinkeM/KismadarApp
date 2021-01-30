package com.example.kismadrapp.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kismadrapp.R
import com.example.kismadrapp.databinding.FragmentPageWelcomeBinding

class WelcomePageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentPageWelcomeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_page_welcome,container,false)
        var viewModel = ViewModelProvider(activity).get(WelcomePageViewModel::class.java)
        return binding.root
    }
}