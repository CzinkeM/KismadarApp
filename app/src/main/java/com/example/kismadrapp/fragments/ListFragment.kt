package com.example.kismadrapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.kismadrapp.R
import com.example.kismadrapp.databinding.FragmentPageListBinding
import com.example.kismadrapp.utils.viewmodelfactories.ListPageFragmentViewModelFactory
import com.example.kismadrapp.viewmodels.ListViewModel


class ListFragment : Fragment() {
    private val args: ListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val category = args.categoryName
        val binding: FragmentPageListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_page_list, container, false)
        val viewModelFactory = ListPageFragmentViewModelFactory(context!!, childFragmentManager)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(ListViewModel::class.java)
        binding.recyclerRestaurant.adapter = viewModel.setAdapter(category)
        binding.recyclerRestaurant.layoutManager = viewModel.setLayoutManager(category)
        //binding.recyclerBackgroundImage.setImageResource(viewModel.setBackground(category))
        return binding.root
    }

}