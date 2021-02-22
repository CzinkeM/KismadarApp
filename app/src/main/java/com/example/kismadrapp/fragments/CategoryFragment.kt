package com.example.kismadrapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.kismadrapp.R
import com.example.kismadrapp.databinding.LayoutCategoryBinding

class CategoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: LayoutCategoryBinding =
            DataBindingUtil.inflate(inflater, R.layout.layout_category, container, false)

        return binding.root
    }
}