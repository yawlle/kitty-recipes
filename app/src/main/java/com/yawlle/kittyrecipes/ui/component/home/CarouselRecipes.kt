package com.yawlle.kittyrecipes.ui.component.home

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.yawlle.kittyrecipes.R
import com.yawlle.kittyrecipes.domain.model.DishTypes
import com.yawlle.kittyrecipes.domain.model.listDishTypes
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun CarouselRecipes(
    items: List<DishTypes>,
    modifier: Modifier,
) {

    var selected by remember { mutableStateOf(0) }
    var selectedFood by remember { mutableStateOf(0) }
    val pagerState = rememberPagerState()
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    LaunchedEffect(pagerState.currentPage) {
        selected = pagerState.currentPage
    }

    LaunchedEffect(selectedFood) {
        listState.scrollToItem(
            index = selectedFood,
            scrollOffset = -100
        )
        Log.d("TAG", "CarouselRecipes: $selectedFood")
    }

    Row {
        LazyColumn(
            state = listState,
            modifier = modifier
                .weight(1f)
                .height(200.dp),
            contentPadding = PaddingValues(horizontal = 3.dp),


            ) {
            itemsIndexed(items) { index, item ->
                val itemModifier = modifier
                    .clickable {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                            selectedFood = index
                        }
                    }

                Text(
                    text = item.name,
                    fontSize = 16.sp,
                    fontWeight = if (item == items[selected]) FontWeight.Bold else FontWeight.Normal,
                    modifier = itemModifier
                        .padding(vertical = 4.dp)

                )
            }
        }


        VerticalPager(
            state = pagerState,
            pageCount = items.size,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .height(200.dp)
                .padding(end = 10.dp)

        ) { page ->

            Card(
                shape = RoundedCornerShape(10.dp),
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
            }
        }
    }
}

@Composable
@Preview
fun CarouselRecipe() {
    CarouselRecipes(items = listDishTypes, modifier = Modifier.fillMaxWidth())
}
