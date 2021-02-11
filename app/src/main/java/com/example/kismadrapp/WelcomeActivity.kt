package com.example.kismadrapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.kismadrapp.welcome.WelcomePageFragment
import kotlin.system.exitProcess
enum class NavigationStatus{MAINPAGE,LISTPAGE,DETAILSPAGE}
class WelcomeActivity : AppCompatActivity() {
    lateinit var navigationStatus: NavigationStatus
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
    }
}