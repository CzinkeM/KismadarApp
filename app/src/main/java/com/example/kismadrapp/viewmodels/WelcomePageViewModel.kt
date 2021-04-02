package com.example.kismadrapp.viewmodels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kismadrapp.R
import com.example.kismadrapp.databinding.LayoutCategoryBinding
import com.example.kismadrapp.models.NatureSight
import com.example.kismadrapp.models.Sight
import com.example.kismadrapp.models.Town
import com.example.kismadrapp.utils.adapters.CategoryAdapter
import com.example.kismadrapp.utils.adapters.CategoryClickListener
import com.example.kismadrapp.utils.clicklisteners.TextClickListener
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.w3c.dom.Text

class WelcomePageViewModel() : ViewModel() {
    private fun openBottomSheet(context: Context){
        val bottomSheetDialog = BottomSheetDialog(context)
        bottomSheetDialog.setContentView(R.layout.bottomsheet_naturesight)
        bottomSheetDialog.show()
    }
    private fun makeBreakfast(context: Context){
        Toast.makeText(context,"Clicked",Toast.LENGTH_SHORT).show()
    }
    fun itemClickListener(context: Context): CategoryClickListener{
        return CategoryClickListener { openBottomSheet(context) }
    }
    fun textClickListener(context: Context): TextClickListener{
        return TextClickListener { makeBreakfast(context) }
    }

}