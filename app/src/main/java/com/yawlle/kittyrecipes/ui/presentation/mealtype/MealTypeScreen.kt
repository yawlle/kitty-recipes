package com.yawlle.kittyrecipes.ui.presentation.mealtype

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.yawlle.kittyrecipes.domain.model.RecipeType

@Composable
fun RecipeTypeScreen(
    navigateToRecipeScreen: (String) -> Unit,
    recipeType: String?
) {
    Text(text = "$recipeType")
}