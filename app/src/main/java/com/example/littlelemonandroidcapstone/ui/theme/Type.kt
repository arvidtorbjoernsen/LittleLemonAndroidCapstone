package com.example.littlelemonandroidcapstone.ui.theme


import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.littlelemonandroidcapstone.R

val KarlaFontFamily = FontFamily(
    Font(R.font.karla_regular, FontWeight.W400),
)

val MarkaziFontFamily = FontFamily(
    Font(R.font.markazi_text_regular, FontWeight.W400),
)

val TypographyStyle = Typography(
    h1 = TextStyle(
        fontFamily = KarlaFontFamily,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        fontSize = 49.sp
    ),
    body1 = TextStyle(
        fontFamily = MarkaziFontFamily,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        fontSize = 24.sp
    ),
)