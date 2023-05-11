package com.yawlle.kittyrecipes.ui.presentation.shimmer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.fade
import com.google.accompanist.placeholder.placeholder
import com.yawlle.kittyrecipes.ui.theme.PrimaryColor
import com.yawlle.kittyrecipes.ui.theme.ShimmerColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoxShimmer(
    modifier: Modifier,
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 3.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(5) {
            Card(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .aspectRatio(1f)
                    .placeholder(
                        visible = true,
                        color = ShimmerColor,
                        highlight = PlaceholderHighlight.fade(
                            highlightColor = PrimaryColor
                        )
                    ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {}
        }
    }
}