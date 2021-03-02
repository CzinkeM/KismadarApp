package com.example.kismadrapp.models

interface MyData {
    fun getTowns(): Collection<Town>
    fun getSights(): Collection<Sight>
    fun getNatureSights(): Collection<NatureSight>
    fun getFoodsAndDrinks(): Collection<FoodAndDrink>
    fun getShops(): Collection<Shop>
    fun getServices(): Collection<Service>
}