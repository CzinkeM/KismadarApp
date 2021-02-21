package com.example.kismadrapp

import android.app.Application
import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SwitchCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.kismadrapp.utils.repository.DataStoreRepository
import com.google.android.material.navigation.NavigationView
import com.google.android.material.switchmaterial.SwitchMaterial
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WelcomeActivityViewModel(application: Application): AndroidViewModel(application) {
    private val repository = DataStoreRepository(application)
    private val context = application.applicationContext

    val readFromDataStore = repository.readFromDataStore.asLiveData()

    fun saveToDataStore(name:String) = viewModelScope.launch(Dispatchers.IO){
        repository.saveToDataStore(name)
    }
    fun checkAndSetSwitchState(switchHU: SwitchMaterial,switchEN: SwitchMaterial){

    }


}