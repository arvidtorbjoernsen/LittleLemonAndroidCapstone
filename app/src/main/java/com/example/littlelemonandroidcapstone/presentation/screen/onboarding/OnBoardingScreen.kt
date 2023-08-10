package com.example.littlelemonandroidcapstone.presentation.screen.onboarding

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemonandroidcapstone.R
import com.example.littlelemonandroidcapstone.navigation.graph.Graph
import com.example.littlelemonandroidcapstone.presentation.component.CustomButton
import com.example.littlelemonandroidcapstone.presentation.component.CustomTextInput
import com.example.littlelemonandroidcapstone.ui.theme.Charcoal
import com.example.littlelemonandroidcapstone.ui.theme.KarlaFont
import com.example.littlelemonandroidcapstone.ui.theme.MarkaziFont
import com.example.littlelemonandroidcapstone.ui.theme.Red
import com.example.littlelemonandroidcapstone.ui.theme.Yellow


@Composable
fun OnBoardingScreen(
    navController: NavHostController,
    onBoardingViewModel: OnBoardingViewModel = hiltViewModel()
) {
    var firstName by remember {
        mutableStateOf("")
    }
    var lastName by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var emailIsValid by remember {
        mutableStateOf(false)
    }
    var firstNameIsValid by remember {
        mutableStateOf(false)
    }
    var lastNameIsValid by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current


    fun onBoardingAction() {
        if (firstNameIsValid && lastNameIsValid && emailIsValid) {
            Toast.makeText(context, "Registration successful!", Toast.LENGTH_SHORT).show()
            navController.popBackStack()
            navController.navigate(Graph.MAIN)
            onBoardingViewModel.saveOnBoardingState(isCompleted = true)
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .imePadding()
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Little Lemon Logo",
            modifier = Modifier
                .width(240.dp)
                .height(52.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.primary),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.catch_frase),
                style = TextStyle(
                    fontSize = 24.sp,
                    color = Color.White,
                    fontFamily = KarlaFont
                ),
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Personal information",
            Modifier.padding(horizontal = 20.dp),
            style = TextStyle(
                fontFamily = MarkaziFont,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
            ),
            color = Charcoal,
        )

        Spacer(modifier = Modifier.weight(1f))
        CustomTextInput(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp),
            text = firstName,
            label = "First name",
            capitalize = true,
            onTextChange = {
                if (it.all { c: Char ->
                        c.isLetter() || c.isWhitespace()
                    }) firstName = it
                firstNameIsValid = firstName.isNotEmpty()
            })
        CustomTextInput(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp),
            text = lastName,
            label = "Last name",
            capitalize = true,
            onTextChange = {
                if (it.all { c: Char ->
                        c.isLetter() || c.isWhitespace()
                    }) lastName = it
                lastNameIsValid = lastName.isNotEmpty()
            })
        CustomTextInput(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp),
            text = email,
            label = "Email",
            keyboardType = KeyboardType.Email,
            onTextChange = {
                email = it
                emailIsValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
            },
        )
        Spacer(modifier = Modifier.weight(12f))
        CustomButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            text = "Register",
            backgroundColor = Yellow,
            contentColor = Charcoal,
            buttonColor = Red,
            enabled = firstNameIsValid && lastNameIsValid && emailIsValid,
            onClick = { onBoardingAction() }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    OnBoardingScreen(rememberNavController())
}