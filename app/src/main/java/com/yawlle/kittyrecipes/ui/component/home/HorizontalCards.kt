package com.yawlle.kittyrecipes.ui.component.home

import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.yawlle.kittyrecipes.R
import com.yawlle.kittyrecipes.domain.model.Recipe
import com.yawlle.kittyrecipes.ui.theme.SecondaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HorizontalCards(
    items: List<Recipe>,
    modifier: Modifier,
    navigateToRecipeScreen: (recipeId: Int) -> Unit,
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 3.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        itemsIndexed(items) { index, item ->
            Card(
                modifier = modifier
                    .clip(RoundedCornerShape(8.dp))
                    .aspectRatio(1f)
                    .clickable {
                        navigateToRecipeScreen(item.id)
                    },
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {
                val painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                    .data(item.image)
                    .size(Size.ORIGINAL)
                    .crossfade(true)
                    .placeholder(R.drawable.food_placeholder)
                    .fallback(R.drawable.food_placeholder)
                    .error(R.drawable.food_placeholder)
                    .build()
                )
                Image(
                    modifier = modifier.background(color = SecondaryColor),
                    painter = painter,
                    contentDescription = "Image Carousel",
                    contentScale = ContentScale.Crop,
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
