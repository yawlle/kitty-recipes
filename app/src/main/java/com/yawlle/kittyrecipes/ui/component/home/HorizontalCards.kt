package com.yawlle.kittyrecipes.ui.component.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.yawlle.kittyrecipes.domain.model.Recipe
import com.yawlle.kittyrecipes.ui.theme.PrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HorizontalCards(
    items: List<Recipe>,
    modifier: Modifier,
) {
    LazyRow(
        modifier = modifier.background(PrimaryColor),
        contentPadding = PaddingValues(horizontal = 3.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        itemsIndexed(items) { index, item ->
            Card(
                modifier = modifier
                    .clip(RoundedCornerShape(8.dp))
                    .aspectRatio(1f)
                    .clickable {

                    },
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {
                AsyncImage(
                    model = item.image,
                    contentDescription = "Image Carousel",
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .drawWithContent {
                            drawContent()
                        },
                )
            }
        }
    }

}

//@Composable
//@Preview
//fun HorizontalCard() {
//    HorizontalCards(items = listDishTypes, modifier = Modifier.fillMaxWidth())
//}
