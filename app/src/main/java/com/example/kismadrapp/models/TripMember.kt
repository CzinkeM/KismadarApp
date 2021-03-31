package com.example.kismadrapp.models

interface TripMember {
    fun addToList(sight: Sight, trip: Trip)
    fun addToList(natureSight: NatureSight,trip: Trip)
}