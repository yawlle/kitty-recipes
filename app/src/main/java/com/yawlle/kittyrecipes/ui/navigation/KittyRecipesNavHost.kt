package com.yawlle.kittyrecipes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yawlle.kittyrecipes.ui.presentation.HomeScreen
import com.yawlle.kittyrecipes.ui.presentation.SplashHomeScreen

@Composable
fun KittyRecipesNavHost(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.Splash.name) {
        composable(Routes.Splash.name) {
            SplashHomeScreen(
                navController = navController,
                navigateToLogin = { navController.navigate(Routes.Home.name) }
            )
        }

        composable(Routes.Home.name) {
            HomeScreen(
                navController = navController,
            )
        }
    }

}

