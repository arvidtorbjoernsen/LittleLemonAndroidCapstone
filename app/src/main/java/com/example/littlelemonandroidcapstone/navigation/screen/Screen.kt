package com.example.littlelemonandroidcapstone.navigation.screen

sealed class Screen(val route: String) {

    object Splash : Screen("splash_screen")

    object OnBoarding : Screen("on_boarding_screen")

    object Home : Screen("home_screen")

    object Profile : Screen("profile_screen")
}