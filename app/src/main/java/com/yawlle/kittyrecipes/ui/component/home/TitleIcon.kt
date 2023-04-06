package com.yawlle.kittyrecipes.ui.component.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yawlle.kittyrecipes.R
import com.yawlle.kittyrecipes.ui.theme.SecondaryColor
import com.yawlle.kittyrecipes.ui.theme.TertiaryColor

@Composable
fun TitleIcon(
    title: String,
    painter: Painter

) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                end = 16.dp
            )
    ) {
        TitleSection(
            title = title,
            modifier = Modifier
                .padding(16.dp)
                .weight(1f),
            color = TertiaryColor,
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(color = SecondaryColor, CircleShape)

        ) {
            Icon(
                painter = painter,
                contentDescription = "Icon",
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(32.dp)
            )
        }


    }
}

@Composable
@Preview
fun TitleIcon() {
    TitleIcon(
        title = "Seja Bem Vindo!",
        painter = painterResource(id = R.drawable.logo_splash)
    )
}
