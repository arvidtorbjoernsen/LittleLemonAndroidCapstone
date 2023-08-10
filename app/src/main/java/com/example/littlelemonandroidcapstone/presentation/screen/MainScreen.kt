package com.example.littlelemonandroidcapstone.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemonandroidcapstone.navigation.graph.MainNavGraph

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController()
) {
    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
        ) {
            MainNavGraph(navController = navController)
        }
    }

}