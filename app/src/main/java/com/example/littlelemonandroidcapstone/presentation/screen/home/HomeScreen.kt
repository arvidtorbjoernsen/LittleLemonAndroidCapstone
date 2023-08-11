package com.example.littlelemonandroidcapstone.presentation.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemonandroidcapstone.R
import com.example.littlelemonandroidcapstone.navigation.screen.Screen
import com.example.littlelemonandroidcapstone.presentation.component.Hero
import com.example.littlelemonandroidcapstone.presentation.component.MenuItems
import com.example.littlelemonandroidcapstone.ui.theme.Cloud
import com.example.littlelemonandroidcapstone.ui.theme.Green
import java.util.Locale

@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val searchQuery by homeViewModel.searchQuery
    val menuItemList by homeViewModel.menItemList.collectAsState()

    val categoriesSet = remember {
        mutableStateOf<Set<String>>(emptySet())
    }

    val categories = remember {
        mutableListOf("all")
    }

    categoriesSet.value = menuItemList.map { it.category }.toSet()

    categories.addAll(categoriesSet.value)


    val selectedCategory = remember { mutableStateOf("") }

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(4f))
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Little Lemon Logo",
                    modifier = Modifier
                        .width(240.dp)
                        .height(52.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = {
                        navController.navigate(Screen.Profile.route)
                    },
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.placeholder_avatar),
                        contentDescription = "Profile",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(20.dp))

                    )
                }
            }
            Hero(
                searchQuery = searchQuery,
                viewModel = homeViewModel
            )
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(10.dp))
            ) {
                LazyRow {
                    items(categories) { category ->
                        Button(
                            onClick = {
                                if (category === "all") {
                                    selectedCategory.value = ""
                                } else if (category === selectedCategory.value) {
                                    selectedCategory.value = ""
                                } else {
                                    selectedCategory.value = category
                                }
                            },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor =
                                if (category === "all" && selectedCategory.value === "") {
                                    Green
                                } else if (category === selectedCategory.value) {
                                    Green
                                } else {
                                    Cloud
                                }
                            ),
                            shape = RoundedCornerShape(50),
                            modifier = Modifier.padding(6.dp)

                        ) {
                            Text(
                                text = category.replaceFirstChar {
                                    if (it.isLowerCase()) it.titlecase(
                                        Locale.getDefault()
                                    ) else it.toString()
                                },
                                color =
                                if (category === "all" && selectedCategory.value === "") {
                                    Cloud
                                } else if (category === selectedCategory.value) {
                                    Cloud
                                } else {
                                    Green
                                }
                            )
                        }

                    }
                }
                MenuItems(menuItemList.filter { menuItem ->
                    (selectedCategory.value.isEmpty() || menuItem.category == selectedCategory.value) &&
                            (searchQuery.isEmpty() || menuItem.title.contains(
                                searchQuery,
                                ignoreCase = true
                            )
                                    )
                })

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScreen(
        navController = rememberNavController(),
    )
}