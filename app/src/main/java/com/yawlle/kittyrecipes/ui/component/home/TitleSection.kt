package com.yawlle.kittyrecipes.ui.component.home

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun TitleSection(
    title: String,
    modifier: Modifier = Modifier,
    color: Color
) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        modifier = modifier,
        color = color
    )
}