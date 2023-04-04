package com.yawlle.kittyrecipes.ui.presentation


import android.os.Bundle
import androidx.annotation.IdRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.yawlle.kittyrecipes.R
import com.yawlle.kittyrecipes.ui.component.SplashImage
import com.yawlle.kittyrecipes.ui.presentation.Constants.SPLASH_SCREEN_DURATION
import com.yawlle.kittyrecipes.ui.theme.SecondaryColor
import kotlinx.coroutines.delay

@Composable
fun SplashHomeScreen(
    navController: NavController,
    navigateToLogin: () -> Unit
) {

    LaunchedEffect(true) {
        delay(SPLASH_SCREEN_DURATION)
        navigateToLogin()
    }

    val image = painterResource(id = R.drawable.logo_splash)

    Surface(
        color = SecondaryColor,
        modifier = Modifier.fillMaxHeight().fillMaxWidth()
    ) {
        SplashImage(modifier = Modifier.height(600.dp).width(570.dp).size(600.dp), contentAlignment = Alignment.Center, image = image)
    }

}

@Composable
@Preview
fun SplashHomeScreenPreview() {

    val context = LocalContext.current
    val mockNavController = object : NavController(context) {
        override fun navigate(
            @IdRes resId: Int,
            args: Bundle?,
            navOptions: NavOptions?,
            navigatorExtras: Navigator.Extras?
            ): Unit = Unit
    }

    SplashHomeScreen(navigateToLogin = {}, navController = mockNavController)
}



