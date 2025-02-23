package com.example.session_2_matule.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.session_2_matule.screens.CatalogScreen
import com.example.session_2_matule.screens.FavoriteScreen
import com.example.session_2_matule.screens.HomeScreen
import com.example.session_2_matule.screens.SplashScreen
import com.example.weather.screens.OnboardingScreen

object NavGraph {
    @Composable
    fun SetupNavGraph(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = Screen.SplashScreen,
            enterTransition = { slideInHorizontally { it } },
            exitTransition = { slideOutHorizontally { -it } },
            popEnterTransition = { slideInHorizontally { it } },
            popExitTransition = { slideOutHorizontally { -it } }
        ) {
            // Splash screen
            composable<Screen.SplashScreen> {
                SplashScreen(
                    onNext = { 
                        navController.navigate(Screen.OnboardingScreen)
                    }
                )
            }

            // Onboarding screen
            composable<Screen.OnboardingScreen> {
                OnboardingScreen(
                    onFinish = { 
                        navController.navigate(Screen.HomeScreen)
                    }
                )
            }

            // Home screen
            composable<Screen.HomeScreen> {
                HomeScreen(
                    onFavoriteClick = {
                        navController.navigate(Screen.FavoriteScreen)
                    },
                    onOutdoorClick = {
                        navController.navigate(Screen.CatalogScreen)
                    },
                    onHomeClick = {
                        navController.navigate(Screen.HomeScreen)
                    },
                    onCartClick = { /* TODO: Add cart screen */ },
                    onMenuClick = { /* TODO: Add cart screen */ },
                    onNotificationClick = { /* TODO: Add notifications screen */ },
                    onProfileClick = { /* TODO: Add profile screen */ }
                )
            }

            // Favorite screen
            composable<Screen.FavoriteScreen> { 
                FavoriteScreen() 
            }

            // Catalog screen
            composable<Screen.CatalogScreen> { 
                CatalogScreen() 
            }
        }
    }
}