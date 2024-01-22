package com.yawlle.kittyrecipes.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.yawlle.kittyrecipes.R

@Composable
fun LoadingAnimation(modifier: Modifier) {
    Column(modifier = modifier) {
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.loader))

        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            isPlaying = true,
            restartOnPlay = true
        )
    }
}