package com.yawlle.kittyrecipes.ui.component.home

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.yawlle.kittyrecipes.R
import com.yawlle.kittyrecipes.ui.theme.PrimaryColor


@Composable
fun TopAppBarHome() {

    val context = LocalContext.current

    val iconMenu = painterResource(id = R.drawable.ic_menu)
    val iconSearch = painterResource(id = R.drawable.ic_search)

    val showMenu = remember {
        mutableStateOf(false)
    }

    CenterAlignedTopAppBar(
        title = {
            Text(
                "",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },
        navigationIcon = {
            IconButton(onClick = { showMenu.value = true }) {
                Icon(
                    iconMenu,
                    contentDescription = "Menu",
                )
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    iconSearch,
                    contentDescription = "Search",
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = PrimaryColor
        )
    )
}

@Composable
@Preview
fun TopAppBarHomeCompose() {
    TopAppBarHome()
}
