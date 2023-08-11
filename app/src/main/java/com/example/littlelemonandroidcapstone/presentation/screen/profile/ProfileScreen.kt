package com.example.littlelemonandroidcapstone.presentation.screen.profile

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemonandroidcapstone.R
import com.example.littlelemonandroidcapstone.navigation.graph.Graph
import com.example.littlelemonandroidcapstone.presentation.component.CustomTextInput
import com.example.littlelemonandroidcapstone.ui.theme.Green
import com.example.littlelemonandroidcapstone.ui.theme.Yellow


@Composable
fun ProfileScreen(
    navController: NavHostController,
    profileViewModel: ProfileViewModel = hiltViewModel()
) {
    LaunchedEffect(true) {
        profileViewModel.readOnBoardingState()
    }
    val firstName = profileViewModel.userFirstName.collectAsState().value
    val lastName = profileViewModel.userLastName.collectAsState().value
    val email = profileViewModel.userEmail.collectAsState().value

    Log.d("State", "First Name: $firstName")
    Log.d("State", "Last Name: $lastName")
    Log.d("State", "Email: $email")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    navController.popBackStack()
                },
            ) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Little Lemon Logo",
                modifier = Modifier
                    .width(240.dp)
                    .height(52.dp)

            )
            Spacer(modifier = Modifier.weight(10f))
        }
        Spacer(modifier = Modifier.weight(5f))
        Column {
            Text(
                text = "Profile information:",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(top = 16.dp, bottom = 30.dp)
            )

            CustomTextInput(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                text = firstName,
                label = "First name",
                onTextChange = {}
            )

            CustomTextInput(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                text = lastName,
                label = "Last name",
                onTextChange = {}
            )

            CustomTextInput(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                text = email,
                label = "Email",
                onTextChange = {}
            )
        }
        Spacer(modifier = Modifier.weight(10f))
        Button(
            onClick = {
                navController.popBackStack()
                navController.navigate(Graph.ROOT)
                profileViewModel.removeOnBoardingState(
                    isCompleted = false,
                    userFirstName = "",
                    userLastName = "",
                    userEmail = ""
                )
            },
            modifier = Modifier
                .padding(top = 16.dp, bottom = 30.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Yellow
            )
        ) {
            Text(
                "Log out",
                color = Green
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    ProfileScreen(rememberNavController())
}