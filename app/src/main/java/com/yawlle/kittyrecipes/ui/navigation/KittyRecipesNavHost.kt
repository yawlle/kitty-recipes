package com.yawlle.kittyrecipes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yawlle.kittyrecipes.ui.presentation.home.HomeScreen
import com.yawlle.kittyrecipes.ui.presentation.SplashHomeScreen
import com.yawlle.kittyrecipes.ui.presentation.mealtype.RecipeScreen
import com.yawlle.kittyrecipes.ui.presentation.mealtype.RecipeTypeScreen

@Composable
fun KittyRecipesNavHost(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.Splash.name) {
        composable(Routes.Splash.name) {
            SplashHomeScreen(
                navigateToLogin = { navController.navigate(Routes.Home.name) }
            )
        }

        composable(Routes.Home.name) {
            val selectedRecipeType = remember { mutableStateOf("") }
            HomeScreen(
                navigateToRecipeTypeScreen = { recipeType ->
                    selectedRecipeType.value = recipeType
                    navController.navigate(Routes.RecipeType.name + "/$recipeType")
                }
            )
        }

        composable(Routes.RecipeType.name + "/{recipeType}") { backStackEntry ->
            val selectedRecipe = remember { mutableStateOf("") }
            val recipeType = backStackEntry.arguments?.getString("recipeType")
            RecipeTypeScreen(
                navigateToRecipeScreen = { recipe ->
                    selectedRecipe.value = recipe
                    navController.navigate(Routes.Recipe.name + "/$recipe")
                },
                recipeType = recipeType
            )
        }

        composable(Routes.Recipe.name + "/{recipe}") { backStackEntry ->
            val recipe = backStackEntry.arguments?.getString("recipe")
            RecipeScreen(recipe = recipe)
        }
    }

}

