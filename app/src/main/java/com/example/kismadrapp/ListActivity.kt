package com.example.kismadrapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgs

class ListActivity : AppCompatActivity() {
    val args: ListActivityArgs by navArgs()
    lateinit var category :String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        category = args.categoryName
    }
}