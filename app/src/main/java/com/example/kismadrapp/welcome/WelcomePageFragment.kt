package com.example.kismadrapp.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kismadrapp.R
import com.example.kismadrapp.databinding.FragmentPageWelcomeBinding

class WelcomePageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentPageWelcomeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_page_welcome,container,false)
        val viewModelFactory = WelcomePageViewModelFactory(resources)
        val viewModel = ViewModelProvider(this,viewModelFactory).get(WelcomePageViewModel::class.java)
        binding.viewModel = viewModel
        binding.recyclerCategory.layoutManager = GridLayoutManager(context,2,RecyclerView.VERTICAL,false)
        binding.recyclerTown.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        binding.recyclerTown.adapter = TownAdapter(TownClickListener {
            townId ->Toast.makeText(context,"Clicked $townId", Toast.LENGTH_SHORT).show()
        },viewModel.getTownList())
        binding.recyclerCategory.adapter = CategoryAdapter(CategoryClickListener { categoryId ->
            chooseCategory(categoryId)
        }, viewModel.getCategoryList())
        binding.viewFlipper.isAutoStart = true
        return binding.root
    }
    private fun chooseCategory(id: String){
        findNavController().navigate(WelcomePageFragmentDirections.actionWelcomePageFragmentToListFragment(id))
    }
}