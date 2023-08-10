package com.example.littlelemonandroidcapstone.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.littlelemonandroidcapstone.navigation.screen.Screen
import com.example.littlelemonandroidcapstone.presentation.screen.home.HomeScreen
import com.example.littlelemonandroidcapstone.presentation.screen.onboarding.OnBoardingScreen
import com.example.littlelemonandroidcapstone.presentation.screen.profile.ProfileScreen
import com.example.littlelemonandroidcapstone.presentation.screen.splash.SplashScreen

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.MAIN,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.OnBoarding.route) {
            OnBoardingScreen(navController = navController)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }
        composable(route = Graph.ROOT) {
            SplashScreen(navController = navController)
        }
    }
}