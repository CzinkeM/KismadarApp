package com.example.kismadrapp.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kismadrapp.R
import com.example.kismadrapp.databinding.FragmentPageWelcomeBinding
import com.example.kismadrapp.model.Category

class WelcomePageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentPageWelcomeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_page_welcome,container,false)
        var viewModel = ViewModelProvider(this).get(WelcomePageViewModel::class.java)
        val categoryAdapter = CategoryAdapter()
        binding.viewModel = viewModel
        viewModel.generateCategoryList(resources)
        viewModel.getCategoryList()
        binding.recyclerCategory.layoutManager = GridLayoutManager(context,2,RecyclerView.VERTICAL,false)
        binding.recyclerTown.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerTown.adapter = TownAdapter(TownClickListener {
            townId ->Toast.makeText(context,"Clicked $townId", Toast.LENGTH_SHORT).show()
        },
            viewModel.townList(resources.getDrawable(R.mipmap.noszvaj_panorama_cut)))
        binding.recyclerCategory.adapter = categoryAdapter
        viewModel.getCategoryList().observe(viewLifecycleOwner, Observer {
            it?.let {
                categoryAdapter.submitList(it)
            }
        })
        return binding.root
    }

}