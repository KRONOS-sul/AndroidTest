package com.example.androidtest.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CarModel(
    val id: Int,
    val name: String,
    val image: String,
    val year: Int,
)
