package com.example.a30diasparaleer.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.a30diasparaleer.R

val AppTypography = Typography()

val CormorantItalic = FontFamily(
    Font(R.font.cormorant_italic),
    Font(R.font.cormorant_italic, FontWeight.Bold)
)
val ReenieBeenie = FontFamily(
    Font(R.font.reenie_beenie_regular),
    Font(R.font.reenie_beenie_regular, FontWeight.Bold)
)
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = CormorantItalic,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    displayMedium = TextStyle(
        fontFamily = ReenieBeenie,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    labelSmall = TextStyle(
        fontFamily = CormorantItalic,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = ReenieBeenie,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )



)