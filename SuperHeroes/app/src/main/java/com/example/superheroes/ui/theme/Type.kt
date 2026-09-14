package com.example.superheroes.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


import androidx.compose.ui.text.font.Font

import com.example.superheroes.R


val Medieval = FontFamily(
    Font (R.font.medieval_sharp_regular, FontWeight.Normal),
    Font(R.font.medieval_sharp_regular, FontWeight.Bold)
)

val Montserrat = FontFamily(
    Font(R.font.montserrat_variable_font_wght, FontWeight.Normal),
    Font(R.font.montserrat_variable_font_wght, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Medieval,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displayLarge = TextStyle(
        fontFamily = Medieval,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    displaySmall = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )
)