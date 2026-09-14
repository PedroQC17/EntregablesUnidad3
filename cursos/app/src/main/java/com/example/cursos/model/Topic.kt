package com.example.cursos.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Topic (
    @StringRes val stringResourceId: Int,
    val numerOfStudents: Int,
    @DrawableRes val imageResourceId: Int
)