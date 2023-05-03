package com.yawlle.kittyrecipes.ui.presentation.mealtype

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yawlle.kittyrecipes.domain.model.RecipeType
import com.yawlle.kittyrecipes.ui.component.TopAppBar
import com.yawlle.kittyrecipes.ui.component.home.TopAppBarHome
import com.yawlle.kittyrecipes.ui.theme.PrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeTypeScreen(
    navigateToRecipeScreen: (String) -> Unit,
    recipeType: RecipeType?
) {
    Scaffold(
        topBar = {
            TopAppBar(recipeType?.name)
        },
        content = {
            Column(
                Modifier
                    .padding(it)
                    .background(color = PrimaryColor)
            ) {
                Text(text = "$recipeType")
            }

        }
    )
}