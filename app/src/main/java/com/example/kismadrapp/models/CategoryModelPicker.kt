package com.example.kismadrapp.models

import com.example.kismadrapp.models.Category
import com.example.kismadrapp.models.CategoryModel

interface CategoryModelPicker {
    fun determineCategory(string: String): Category
    fun getDetailedModel(category: Category): CategoryModel
}