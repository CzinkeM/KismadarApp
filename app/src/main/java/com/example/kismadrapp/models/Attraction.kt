package com.example.kismadrapp.models

interface Attraction: Location {
    fun addToTripList(item: Category)
}