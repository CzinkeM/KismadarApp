package com.example.kismadrapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.kismadrapp.R
import com.example.kismadrapp.databinding.FragmentMyTripsBinding
import com.example.kismadrapp.models.CategoryModel
import com.example.kismadrapp.models.Trip
import com.example.kismadrapp.utils.adapters.TripAdapter
import com.example.kismadrapp.utils.adapters.TripClickListener
import com.example.kismadrapp.utils.getNatureSights

class MyTripsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        val binding: FragmentMyTripsBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_my_trips,container,false)
        val testTripList = listOf<Trip>()
        binding.tripRecyclerView .adapter = TripAdapter(TripClickListener {
            Toast.makeText(context,"${it.name}, destiantions: ${it.destinations.size}",Toast.LENGTH_SHORT).show()
        },testTripList)

        return binding.root
    }
}