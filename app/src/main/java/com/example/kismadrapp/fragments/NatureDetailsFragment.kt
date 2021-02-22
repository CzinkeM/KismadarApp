package com.example.kismadrapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.kismadrapp.R
import com.example.kismadrapp.databinding.FragmentNatureDetailsBinding

class NatureDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentNatureDetailsBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_nature_details,container,false)
        return binding.root
    }
}