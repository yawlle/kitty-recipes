package com.yawlle.kittyrecipes.ui.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yawlle.kittyrecipes.domain.model.RecipeType
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

            HomeScreen(
                navigateToRecipeTypeScreen = { recipeType ->

                    navController.previousBackStackEntry?.savedStateHandle?.set(
                        key = "recipeType",
                        value = Gson().toJson(recipeType)
                    )
                    navController.navigate(Routes.RecipeType.name + "/$recipeType")

//                    selectedRecipeType.value = recipeType.APIname
//                    navController.navigate(Routes.RecipeType.name + "/${recipeType.APIname}")
                }
            )
        }

        composable(
            route = Routes.RecipeType.name + "/{recipeType}",
            arguments = listOf(
                navArgument("recipeType") {
                    type = NavType.StringType
                },
            )
        ) { backStackEntry ->

            val jsonClient = backStackEntry.arguments?.getString("recipeType")
            val recipeType = object : TypeToken<RecipeType>() {}.type
            val recipe = Gson().fromJson<RecipeType>(jsonClient, recipeType)

            RecipeTypeScreen(
                navigateToRecipeScreen = { recipe ->
                    navController.previousBackStackEntry?.savedStateHandle?.set(
                        key = "recipeType",
                        value = Gson().toJson(recipe)
                    )
                    navController.navigate(Routes.Recipe.name + "/$recipe")

                }, recipeType = recipe)


//            val selectedRecipe = remember { mutableStateOf("") }
//            val recipeType = backStackEntry.arguments?.getString("recipeType")
//            RecipeTypeScreen(
//                navigateToRecipeScreen = { recipe ->
//                    selectedRecipe.value = recipe
//                    navController.navigate(Routes.Recipe.name + "/$recipe")
//                },
//                recipeType = recipeType
//            )
        }

        composable(Routes.Recipe.name + "/{recipe}") { backStackEntry ->
            val recipe = backStackEntry.arguments?.getString("recipe")
            RecipeScreen(recipe = recipe)
        }
    }

}

@Composable
inline fun <reified T> NavHostController.getParam(
    paramName: String,
): T? {
    val type = object : TypeToken<T>() {}.type
    val json = getBackArg<String>(paramName)?.collectAsState()
    return Gson().fromJson<T>(json?.value, type)
}

fun <T> NavHostController.getBackArg(
    argKey: String
) = currentBackStackEntry
    ?.savedStateHandle
    ?.getStateFlow<T?>(argKey, null)

fun <T> getEncodedJsonParam(
    rawParam: T
): String {
    val jsonParam = Gson().toJson(rawParam)
    return Uri.encode(jsonParam)
}

