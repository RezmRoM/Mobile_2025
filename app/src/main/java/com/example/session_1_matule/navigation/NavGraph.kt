package com.example.session_1_matule.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.session_1_matule.screens.HomeScreen
import com.example.session_1_matule.screens.authorization.AuthorizationScreen

object NavGraph {
    @Composable
    fun SetupNavGraph(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = Screen.AuthorizationScreen,
            enterTransition = { slideInHorizontally { it } },
            exitTransition = { slideOutHorizontally { -it } },
            popEnterTransition = { slideInHorizontally { it } },
            popExitTransition = { slideOutHorizontally { -it } },
            ) {
            composable<Screen.AuthorizationScreen> {
                AuthorizationScreen(
                    onLoginClick = {
                        navController.navigate(Screen.HomeScreen)
                    }
                )
            }
            composable<Screen.HomeScreen> {
                HomeScreen()
            }
        }
    }
}
