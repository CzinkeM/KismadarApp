package com.example.kismadrapp.banner

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.kismadrapp.R
import java.util.*
import kotlin.concurrent.schedule

class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_view_pager, container, false)
        val fragmentList = arrayListOf(
            BannerDiscoverFragment(), BannerEventFragment()
        )
        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = adapter
        return view
    }
}