package com.example.kismadrapp.utils.clicklisteners

import com.example.kismadrapp.models.Location

class TextClickListener (val clickListener: (id: String) -> Unit) {
    fun onClick(string: String) = clickListener(string)
}