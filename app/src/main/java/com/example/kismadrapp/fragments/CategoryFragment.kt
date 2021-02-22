package com.example.kismadrapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kismadrapp.R
import com.example.kismadrapp.databinding.LayoutCategoryBinding
import com.example.kismadrapp.list.Nature
import com.example.kismadrapp.list.NatureType
import com.example.kismadrapp.welcome.CategoryAdapter
import com.example.kismadrapp.welcome.CategoryClickListener

class CategoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: LayoutCategoryBinding = DataBindingUtil.inflate(inflater,R.layout.layout_category,container,false)

        return binding.root
    }
}