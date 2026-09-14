package com.example.a30diasparaleer.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Book (
    @StringRes val nameRes : Int,
    @StringRes val descriptionRes : Int,
    @DrawableRes val imageRes : Int,
){


}