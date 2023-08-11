package com.example.littlelemonandroidcapstone.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemonandroidcapstone.R
import com.example.littlelemonandroidcapstone.presentation.screen.home.HomeViewModel
import com.example.littlelemonandroidcapstone.ui.theme.Charcoal
import com.example.littlelemonandroidcapstone.ui.theme.Cloud
import com.example.littlelemonandroidcapstone.ui.theme.Green
import com.example.littlelemonandroidcapstone.ui.theme.KarlaFont
import com.example.littlelemonandroidcapstone.ui.theme.MarkaziFont
import com.example.littlelemonandroidcapstone.ui.theme.Yellow

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Hero(
    searchQuery: String,
    viewModel: HomeViewModel
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier.background(Green),
    ) {
        Column(
            modifier = Modifier

                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = stringResource(id = R.string.title),
                style = TextStyle(
                    fontFamily = MarkaziFont,
                    fontSize = 58.sp,

                    ),
                color = Yellow
            )
            Text(
                text = stringResource(id = R.string.location),
                style = TextStyle(
                    fontFamily = MarkaziFont,
                    fontSize = 36.sp,
                ),
                color = Cloud,
                modifier = Modifier.offset(y = (-20).dp)
            )
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .offset(y = (-40).dp)
            ) {
                Text(
                    text = stringResource(id = R.string.description),
                    style = TextStyle(
                        fontFamily = KarlaFont,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxWidth(0.55f),
                    color = Cloud
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.hero_image),
                    contentDescription = "Food on a tray",
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .height(150.dp)
                        .width(150.dp),
                    contentScale = ContentScale.Crop
                )

            }
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-20).dp),
                value = searchQuery,
                label = { Text("Enter search phrase") },
                onValueChange = viewModel::onSearchQueryChange,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = Charcoal
                    )
                },
                textStyle = TextStyle.Default.copy(fontSize = 20.sp, fontFamily = KarlaFont),
                maxLines = 1,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done,
                ),
                keyboardActions = KeyboardActions(onDone = {
                    keyboardController?.hide()
                }),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = Color.White,
                    textColor = Charcoal,
                    unfocusedBorderColor = Charcoal,
                    focusedBorderColor = Charcoal,
                    focusedLabelColor = Color.Blue,
                    unfocusedLabelColor = Charcoal,
                ),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeroPreview() {


}