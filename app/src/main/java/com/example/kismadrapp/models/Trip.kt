package com.example.kismadrapp.models

import java.util.*

class Trip(): TripManager {

    lateinit var name: String
    lateinit var destinations: LinkedList<Location>

    private constructor(tripName: String, destinations: LinkedList<Location>): this(){
        this.name = tripName
        this.destinations = destinations
    }

    override fun addToList(location: Location) {
        this.destinations.add(location)
    }

    override fun size(): Int {
        return this.destinations.size
    }

    override fun create(name: String): Trip {
        return Trip(name,LinkedList())
    }
}