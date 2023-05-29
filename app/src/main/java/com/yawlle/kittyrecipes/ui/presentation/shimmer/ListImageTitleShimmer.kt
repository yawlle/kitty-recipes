package com.yawlle.kittyrecipes.ui.presentation.shimmer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.fade
import com.google.accompanist.placeholder.placeholder
import com.yawlle.kittyrecipes.ui.theme.ShimmerColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListImageTitleShimmer(
    modifier: Modifier,
) {
    LazyColumn(
        modifier = modifier.padding(16.dp),
        contentPadding = PaddingValues(horizontal = 3.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(20) {
            Card(
                modifier = modifier
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Row(
                    modifier = modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = modifier
                            .clip(RoundedCornerShape(8.dp))
                            .size(100.dp)
                            .placeholder(
                                visible = true,
                                color = ShimmerColor,
                                highlight = PlaceholderHighlight.fade(
                                    highlightColor = Color.Gray
                                )
                            )
                    )
                    Text(
                        text = "Texto grande para servir de placeholder",
                        fontSize = 21.sp,
                        maxLines = 2,
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .placeholder(
                                visible = true,
                                color = ShimmerColor,
                                highlight = PlaceholderHighlight.fade(
                                    highlightColor = Color.Gray,
                                ),
                            )
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun ListImageTitleShimmerPreview() {
    ListImageTitleShimmer(modifier = Modifier)
}