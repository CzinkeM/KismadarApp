package com.example.kismadrapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.navArgs
import com.example.kismadrapp.R

class ListActivity : AppCompatActivity() {
    val args: ListActivityArgs by navArgs()
    lateinit var category :String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        category = args.categoryName
    }
}