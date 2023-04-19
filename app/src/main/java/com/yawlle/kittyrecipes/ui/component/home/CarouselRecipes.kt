package com.yawlle.kittyrecipes.ui.component.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import com.yawlle.kittyrecipes.R
import com.yawlle.kittyrecipes.domain.model.DishType
import com.yawlle.kittyrecipes.domain.model.listDishTypes
import com.yawlle.kittyrecipes.ui.theme.PrimaryColor
import kotlin.math.absoluteValue

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun CarouselRecipes(
    items: List<DishType>,
    modifier: Modifier,
) {

    var selected by remember { mutableStateOf(0) }
    var selectedFood by remember { mutableStateOf(0) }
    val pagerState = rememberPagerState()
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()


    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {

        HorizontalPager(
            pageCount = items.size
        ) { page ->
            Card(
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = PrimaryColor,
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )

            ) {
                Image(
                    painter = painterResource(items[page].image ?: R.drawable.appetizer),
                    contentDescription = items[page].name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Text(
                    text = items[page].name,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally),
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }

        }


    }
}

@Composable
@Preview
fun CarouselRecipe() {
    CarouselRecipes(items = listDishTypes, modifier = Modifier.fillMaxWidth())
}
