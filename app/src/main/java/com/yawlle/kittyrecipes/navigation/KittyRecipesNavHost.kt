package com.yawlle.kittyrecipes.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yawlle.kittyrecipes.domain.model.RecipeType
import com.yawlle.kittyrecipes.ui.presentation.SplashHomeScreen
import com.yawlle.kittyrecipes.ui.presentation.home.HomeScreen
import com.yawlle.kittyrecipes.ui.presentation.recipetype.RecipeScreen
import com.yawlle.kittyrecipes.ui.presentation.recipetype.RecipeTypeScreen

@Composable
fun KittyRecipesNavHost(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.Splash.name) {
        composable(Routes.Splash.name) {
            SplashHomeScreen(
                navigateToLogin = { navController.navigate(Routes.Home.name) }
            )
        }

        composable(Routes.Home.name) {

            HomeScreen(
                navigateToRecipeTypeScreen = { recipeType ->
                    val encodedRecipeType = getEncodedJsonParam(recipeType)
                    navController.navigate("${Routes.RecipeType.name}/$encodedRecipeType?recipeType=$encodedRecipeType")
                }
            )
        }

        composable(
            route = Routes.RecipeType.name + "/{recipeType}?recipeType={recipeType}",
            arguments = listOf(
                navArgument("recipeType") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            val jsonClient = entry.arguments?.getString("recipeType")
            val recipeTypeToken = object : TypeToken<RecipeType>() {}.type
            val recipeType = Gson().fromJson<RecipeType>(jsonClient, recipeTypeToken)

            RecipeTypeScreen(
                recipeType,
                onBackClick = { navController.popBackStack() },
                navigateToRecipeScreen = { recipeId ->
                    navController.navigate("${Routes.Recipe.name}/$recipeId?recipeId=$recipeId")
                }
            )
        }

        composable(
            route = Routes.Recipe.name + "/{recipeId}",
            arguments = listOf(
                navArgument("recipeId") {
                    type = NavType.StringType
                }
            )
        )
        { entry ->
            val recipeId = entry.arguments?.getString("recipeId")
            RecipeScreen(recipeId = recipeId)
        }
    }

}

fun <T> getEncodedJsonParam(
    rawParam: T
): String {
    val jsonParam = Gson().toJson(rawParam)
    return Uri.encode(jsonParam)
}

