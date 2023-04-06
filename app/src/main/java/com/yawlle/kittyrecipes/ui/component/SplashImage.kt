package com.yawlle.kittyrecipes.ui.component


import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yawlle.kittyrecipes.R

@Composable
fun SplashImage(
    modifier: Modifier,
    image: Painter,
    contentAlignment: Alignment = Alignment.Center
) {
    val size = remember {
        Animatable(1f)
    }

    LaunchedEffect(Unit) {
        size.animateTo(
            targetValue = 2.5f,
            animationSpec = spring(stiffness = Spring.StiffnessLow)
        )
        size.animateTo(
            targetValue = 2f,
            animationSpec = spring(stiffness = Spring.StiffnessLow)
        )
    }

    Box(
        modifier = modifier,
        contentAlignment = contentAlignment
    ) {
        Image(
            painter = image,
            contentDescription = "Splash Image",
            modifier = Modifier.scale(size.value),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
@Preview
fun SplashImage() {
    val image = painterResource(id = R.drawable.logo_splash)
    SplashImage(
        modifier = Modifier
            .height(100.dp)
            .width(70.dp),
        contentAlignment = Alignment.Center,
        image = image
    )
}

