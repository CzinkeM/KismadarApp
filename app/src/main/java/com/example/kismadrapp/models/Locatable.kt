package com.example.kismadrapp.models

interface Locatable {
    fun locate(sight: Sight)
    fun locate(natureSight: NatureSight)
}