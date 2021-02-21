package com.example.kismadrapp.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.kismadrapp.R
import com.example.kismadrapp.model.CategoryModel

class DetailDialogFragment(categoryModel: CategoryModel): DialogFragment() {
    //attól függ hogy milyen class használja
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.layout_nature_detailed,container,false)
    }
}