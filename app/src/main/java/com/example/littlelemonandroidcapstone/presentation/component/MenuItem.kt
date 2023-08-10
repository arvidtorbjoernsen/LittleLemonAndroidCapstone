package com.example.littlelemonandroidcapstone.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.littlelemonandroidcapstone.domain.model.MenuItem
import com.example.littlelemonandroidcapstone.ui.theme.Charcoal


@Composable
fun MenuItem(menuItem: MenuItem) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(color = Color.White),

        ) {

        Column(
            modifier = Modifier
                .padding(start = 10.dp)
                .fillMaxWidth(0.5f)
        ) {
            Text(
                text = menuItem.title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = menuItem.description,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .padding(top = 5.dp, bottom = 5.dp)
            )
            Text(
                text = "$${menuItem.price}",
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(bottom = 8.dp)
            )

        }
        Image(
            painter = rememberAsyncImagePainter(menuItem.image),
            contentDescription = "Menu item",
            modifier = Modifier.size(150.dp)
        )
    }
    Divider(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        thickness = 1.dp,
        color = Charcoal
    )
}

