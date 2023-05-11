package com.yawlle.kittyrecipes.ui.presentation.recipetype

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RecipeScreen(recipeId: String?) {
    Text(text = recipeId ?: "", modifier = Modifier)
}