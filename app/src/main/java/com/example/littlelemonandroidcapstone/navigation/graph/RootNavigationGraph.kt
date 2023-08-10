package com.example.littlelemonandroidcapstone.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.littlelemonandroidcapstone.navigation.screen.Screen
import com.example.littlelemonandroidcapstone.presentation.screen.MainScreen
import com.example.littlelemonandroidcapstone.presentation.screen.onboarding.OnBoardingScreen
import com.example.littlelemonandroidcapstone.presentation.screen.splash.SplashScreen

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.OnBoarding.route) {
            OnBoardingScreen(navController = navController)
        }

        composable(route = Graph.MAIN) {
            MainScreen()
        }
    }
}