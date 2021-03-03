package com.example.kismadrapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kismadrapp.R
import com.example.kismadrapp.databinding.FragmentDetailsNatureBinding
import com.example.kismadrapp.models.NatureSight
import com.example.kismadrapp.models.NatureSightType

class NatureDetailsFragment : Fragment() {
    private val args: NatureDetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentDetailsNatureBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_details_nature, container, false)
        binding.nature = getNatureObject(args.natureName)
        binding.buttonBackNature.setOnClickListener {
            findNavController().navigate(NatureDetailsFragmentDirections.natureDetailsFragmentToWelcomePageFragment())
        }
        return binding.root
    }

    private fun getNatureObject(string: String): NatureSight {
        val imgNature = ResourcesCompat.getDrawable(context!!.resources, R.drawable.vector_hiking, null)!!
        val gottenNature = NatureSight(
            "Test ViewPoint",
            NatureSightType.VIEWPOINT, "Ez egy leírás", imgNature
        )
        val defaultNature = NatureSight(
            "Default ViewPoint",
            NatureSightType.VIEWPOINT, getString(R.string.loremipsum), imgNature
        )
        return when (string) {
            "Test ViewPoint" -> gottenNature
            else -> defaultNature
        }
    }
}