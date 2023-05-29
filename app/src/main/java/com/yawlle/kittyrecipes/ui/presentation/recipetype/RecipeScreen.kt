package com.yawlle.kittyrecipes.ui.presentation.recipetype

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.yawlle.kittyrecipes.domain.model.Recipe
import com.yawlle.kittyrecipes.domain.model.listRecipesMock
import com.yawlle.kittyrecipes.ui.component.TopAppFavorite
import com.yawlle.kittyrecipes.ui.component.home.TopAppBarHome
import com.yawlle.kittyrecipes.ui.theme.PrimaryColor
import com.yawlle.kittyrecipes.ui.theme.TertiaryColor

@Composable
fun RecipeScreen(
    recipeId: String?,
    onBackClick: () -> Unit,
    vm: RecipeViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = recipeId) {
        vm.getRecipeById(recipeId)
    }

    val recipeState = vm.recipeState.collectAsState().value

    RecipeScreen(recipeState, onBackClick)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RecipeScreen(
    recipeState: RecipeState,
    onBackClick: () -> Unit
) {

    Scaffold(topBar = {
        TopAppFavorite(onBackClick = onBackClick)
    }, content = {
        Column(
            Modifier
                .padding(it)
                .background(color = PrimaryColor)
                .fillMaxHeight()
        ) {
            if (recipeState.isLoading) {

            } else {
                AsyncImage(
                    model = recipeState.recipe?.image ?: "",
                    contentDescription = "Image Recipe",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.40f)
                        .drawWithContent {
                            drawContent()
                        },
                )

            }

        }
    })


}

@Composable
@Preview
fun RecipeScreenCompose() {
    val recipeState = remember { RecipeState(recipe = listRecipesMock[0]) }
    RecipeScreen(recipeState = recipeState, onBackClick = {})
}


