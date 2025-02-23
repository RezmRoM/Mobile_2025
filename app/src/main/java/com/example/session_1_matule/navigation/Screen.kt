package com.example.session_1_matule.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {

    @Serializable
    data object AuthorizationScreen : Screen

    @Serializable
    data object HomeScreen : Screen

}