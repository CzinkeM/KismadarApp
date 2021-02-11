package com.example.kismadrapp.list

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


class ListFragment : Fragment() {
    private val args: ListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentPageListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_page_list, container, false)
        val viewModelFactory = ListPageFragmentViewModelFactory(context!!)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(ListViewModel::class.java)
        val category = args.category
        binding.recyclerRestaurant.adapter = viewModel.setAdapter(category)
        binding.recyclerRestaurant.layoutManager = viewModel.setLayoutManager(category)
        binding.recyclerBackgroundImage.setImageResource(viewModel.setBackground(category))

        return binding.root
    }

}