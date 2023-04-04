package com.yawlle.kittyrecipes.ui.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun LoginScreen(
    navController: NavHostController,
) {
    Greetingg(name = "oie")
}


@Composable
fun Greetingg(name: String) {
    Text(text = "Hello $name!")
}