package com.example.kismadrapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kismadrapp.NatureType
import com.example.kismadrapp.R
import com.example.kismadrapp.databinding.FragmentDetailsNatureBinding
import com.example.kismadrapp.models.Nature

class NatureDetailsFragment : Fragment() {
    private val args: NatureDetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentDetailsNatureBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_details_nature,container,false)
        binding.nature = getNatureObject(args.natureName)
        binding.natureBackButton.setOnClickListener {
            findNavController().navigate(NatureDetailsFragmentDirections.actionNatureDetailsFragmentToWelcomePageFragment2())
        }
        return binding.root
    }
    private fun getNatureObject(string: String): Nature{
        val imgNature =
            ResourcesCompat.getDrawable(context!!.resources, R.drawable.vector_trip, null)!!
        val gottenNature = Nature(
            "Test ViewPoint",
            NatureType.VIEWPOINT, "Ez egy leírás", imgNature, null
        )
        val defaultNature = Nature(
            "Default ViewPoint",
            NatureType.VIEWPOINT, getString(R.string.loremipsum), imgNature, null
        )
        return when(string){
            "Test ViewPoint" -> gottenNature
            else -> defaultNature
        }
    }
}