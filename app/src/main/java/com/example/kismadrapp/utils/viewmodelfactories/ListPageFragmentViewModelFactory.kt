package com.example.kismadrapp.utils.viewmodelfactories

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kismadrapp.viewmodels.ListViewModel

class ListPageFragmentViewModelFactory(
    private val context: Context,
    private val fragmentManager: FragmentManager
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
            return ListViewModel(context, fragmentManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}