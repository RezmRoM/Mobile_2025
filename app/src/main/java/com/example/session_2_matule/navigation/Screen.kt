package com.example.session_2_matule.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object SplashScreen : Screen

    @Serializable
    data object OnboardingScreen : Screen

    @Serializable
    data object HomeScreen : Screen

    @Serializable
    data object FavoriteScreen : Screen

    @Serializable
    data object CatalogScreen : Screen
}