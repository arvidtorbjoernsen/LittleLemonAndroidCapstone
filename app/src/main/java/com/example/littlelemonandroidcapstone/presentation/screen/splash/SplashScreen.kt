package com.example.littlelemonandroidcapstone.presentation.screen.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.littlelemonandroidcapstone.R
import com.example.littlelemonandroidcapstone.navigation.graph.Graph
import com.example.littlelemonandroidcapstone.navigation.screen.Screen
import com.example.littlelemonandroidcapstone.ui.theme.Cloud
import com.example.littlelemonandroidcapstone.ui.theme.Green

import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController,
    splashViewModel: SplashViewModel = hiltViewModel()
) {
    val onBoardingIsCompleted by splashViewModel.onBoardingIsCompleted.collectAsState()
    val scale = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 5f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(7f).getInterpolation(it)
                }
            )
        )
        delay(1200L)
        navController.popBackStack()

        if (onBoardingIsCompleted) navController.navigate(Graph.MAIN)
        else navController.navigate(Screen.OnBoarding.route)
    }

    Splash(scale = scale.value)
}

@Composable
fun Splash(
    modifier: Modifier = Modifier,
    scale: Float
) {
    Box(
        modifier = modifier
            .background(Cloud)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .scale(scale)
                .padding(all = 64.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = stringResource(R.string.logo_app)
        )
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    Splash(scale = 6f)
}