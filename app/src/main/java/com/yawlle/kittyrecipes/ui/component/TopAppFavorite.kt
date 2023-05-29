package com.yawlle.kittyrecipes.ui.component

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import com.yawlle.kittyrecipes.R
import com.yawlle.kittyrecipes.ui.theme.PrimaryColor

@Composable
fun TopAppFavorite(
    title: String? = "",
    onBackClick: () -> Unit
) {

    //Compose does not allow a mutable property to be used directly as a variable in the main scope of a composable.
    val isFavoriteState = remember { mutableStateOf(false) }
    var isFavorite by isFavoriteState

    val iconBack = painterResource(id = R.drawable.baseline_arrow_back)
    val iconFavoriteOff = painterResource(id = R.drawable.favorite_off)
    val iconFavoriteOn = painterResource(id = R.drawable.favorite_on)

    CenterAlignedTopAppBar(
        title = {
            run {}
        },
        navigationIcon = {
            IconButton(onClick = { onBackClick() }) {
                Icon(
                    iconBack,
                    contentDescription = "Voltar",
                )
            }
        },
        actions = {
            IconButton(
                onClick = { isFavorite = !isFavorite }
            ) {
                Icon(
                    if (isFavorite) iconFavoriteOn else iconFavoriteOff,
                    contentDescription = "Search",
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = PrimaryColor
        )
    )

}