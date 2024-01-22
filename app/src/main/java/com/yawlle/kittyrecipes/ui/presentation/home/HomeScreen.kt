package com.yawlle.kittyrecipes.ui.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yawlle.kittyrecipes.R
import com.yawlle.kittyrecipes.domain.model.Recipe
import com.yawlle.kittyrecipes.domain.model.RecipeType
import com.yawlle.kittyrecipes.domain.model.listRecipeTypes
import com.yawlle.kittyrecipes.ui.common.ErrorScreen
import com.yawlle.kittyrecipes.ui.common.LoadingAnimation
import com.yawlle.kittyrecipes.ui.common.ScreenState
import com.yawlle.kittyrecipes.ui.component.home.TopAppBarHome
import com.yawlle.kittyrecipes.ui.component.home.CarouselRecipes
import com.yawlle.kittyrecipes.ui.component.home.HorizontalCards
import com.yawlle.kittyrecipes.ui.component.home.TitleIcon
import com.yawlle.kittyrecipes.ui.component.home.TitleSection
import com.yawlle.kittyrecipes.ui.presentation.shimmer.BoxShimmer
import com.yawlle.kittyrecipes.ui.theme.PrimaryColor
import com.yawlle.kittyrecipes.ui.theme.TertiaryColor

@Composable
fun HomeScreen(
    navigateToRecipeTypeScreen: (RecipeType) -> Unit,
    vm: HomeViewModel = hiltViewModel()
) {

    val screenState by vm.uiState.screenState.collectAsState()
    val recipes by vm.uiState.recipes.collectAsState()

    when (val state = screenState) {

        is ScreenState.Loading -> {
            LoadingAnimation(modifier = Modifier.fillMaxSize().background(color = PrimaryColor))
        }

        is ScreenState.Error -> {
            ErrorScreen(modifier = Modifier.fillMaxSize(), subtitle = state.message)
        }

        is ScreenState.Content -> {
            HomeScreen(recipes, navigateToRecipeTypeScreen)
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun HomeScreen(
    recipes: List<Recipe>,
    navigateToRecipeTypeScreen: (RecipeType) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBarHome()
        },
        content = {
            Column(
                Modifier
                    .padding(it)
                    .background(color = PrimaryColor)
                    .fillMaxHeight(2f)
            ) {
                TitleIcon(
                    title = stringResource(id = R.string.home_title),
                    painter = painterResource(id = R.drawable.logo_splash)
                )
                TitleSection(
                    title = stringResource(id = R.string.home_section_title),
                    modifier = Modifier.padding(16.dp),
                    color = TertiaryColor
                )
                CarouselRecipes(
                    items = listRecipeTypes,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    navigateToRecipeTypeScreen = navigateToRecipeTypeScreen
                )
                Spacer(modifier = Modifier.height(10.dp))
                TitleSection(
                    title = stringResource(id = R.string.section_title),
                    modifier = Modifier.padding(16.dp),
                    color = TertiaryColor
                )
                HorizontalCards(
                    items = recipes,
                    modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth()
                )
            }

        }
    )
}
