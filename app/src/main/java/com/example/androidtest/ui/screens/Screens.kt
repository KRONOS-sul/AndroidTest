package com.example.androidtest.ui.screens

sealed class Screens(val route: String) {
    data object CarsScreen : Screens("car_screen")
    data object CarDetailScreen : Screens("car_detail_screen")
}