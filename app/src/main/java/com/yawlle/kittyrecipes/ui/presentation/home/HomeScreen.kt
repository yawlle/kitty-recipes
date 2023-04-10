package com.yawlle.kittyrecipes.ui.presentation

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.yawlle.kittyrecipes.R
import com.yawlle.kittyrecipes.data.recipeCategoryMock
import com.yawlle.kittyrecipes.domain.model.listDishTypes
import com.yawlle.kittyrecipes.ui.component.TopAppBarCompose
import com.yawlle.kittyrecipes.ui.component.home.CarouselRecipes
import com.yawlle.kittyrecipes.ui.component.home.TitleIcon
import com.yawlle.kittyrecipes.ui.component.home.TitleSection
import com.yawlle.kittyrecipes.ui.theme.PrimaryColor
import com.yawlle.kittyrecipes.ui.theme.TertiaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
) {
    Scaffold(
        topBar = {
            TopAppBarCompose()
        },
        content = {
            Column(
                Modifier
                    .padding(it)
                    .background(color = PrimaryColor)
                    .fillMaxHeight(2f)) {
                TitleIcon(
                    title = "Seja Bem Vindo!",
                    painter = painterResource(id = R.drawable.logo_splash)
                )
                TitleSection(
                    title = "Hora de testar novos sabores!",
                    modifier = Modifier.padding(16.dp),
                    color = TertiaryColor
                )
                CarouselRecipes (
                    items = listDishTypes,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    )
}

@Composable
@Preview
fun HomeScreenPreview() {

    val context = LocalContext.current
    val mockNavController = object : NavController(context) {
        override fun navigate(
            @IdRes resId: Int,
            args: Bundle?,
            navOptions: NavOptions?,
            navigatorExtras: Navigator.Extras?
        ): Unit = Unit
    }

    HomeScreen(navController = mockNavController)
}

