package com.example.session_1_matule.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.session_1_matule.R

object AppIcons {
    @Composable
    fun VisibilityOff() = painterResource(id = R.drawable.ic_visibility_off)

    @Composable
    fun VisibilityOn() = painterResource(id = R.drawable.ic_visibility_on)
}