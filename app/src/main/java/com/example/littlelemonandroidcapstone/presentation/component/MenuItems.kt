package com.example.littlelemonandroidcapstone.presentation.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.littlelemonandroidcapstone.domain.model.MenuItem

@Composable
fun MenuItems(itemsList: List<MenuItem>) {
    LazyColumn {
        items(itemsList) { menuItem ->
            MenuItem(menuItem = menuItem)
        }
    }
}