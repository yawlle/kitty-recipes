package com.yawlle.kittyrecipes.ui.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yawlle.kittyrecipes.R
import com.yawlle.kittyrecipes.domain.model.Recipe
import com.yawlle.kittyrecipes.domain.model.RecipeType
import com.yawlle.kittyrecipes.domain.model.listRecipeTypes
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

    val list = vm.recipeState.collectAsState().value.items
    val homeState = vm.recipeState.collectAsState().value

    HomeScreen(homeState, navigateToRecipeTypeScreen)
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun HomeScreen(
    homeState: HomeState,
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
                    title = "Seja Bem Vindo!",
                    painter = painterResource(id = R.drawable.logo_splash)
                )
                TitleSection(
                    title = "Hora de testar novos sabores.",
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
                    title = "Faça uma surpresa...",
                    modifier = Modifier.padding(16.dp),
                    color = TertiaryColor
                )
                if (homeState.isLoading) {
                    BoxShimmer(
                        modifier = Modifier
                            .height(120.dp)
                            .fillMaxWidth()
                    )
                } else {
                    HorizontalCards(
                        items = homeState.items,
                        modifier = Modifier
                            .height(120.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
    )
}
