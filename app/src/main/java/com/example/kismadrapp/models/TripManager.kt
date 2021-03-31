package com.example.kismadrapp.models

interface TripManager {
    fun addToList(location: Location)
    fun size(): Int
    fun create(name: String): Trip
}