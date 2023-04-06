package com.yawlle.kittyrecipes.ui.component.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yawlle.kittyrecipes.data.recipeCategoryMock
import com.yawlle.kittyrecipes.domain.model.CarouselCategory
import com.yawlle.kittyrecipes.domain.model.DishTypes
import com.yawlle.kittyrecipes.domain.model.listDishTypes
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun CarouselRecipes(
    items: List<DishTypes>,
    modifier: Modifier,
) {

    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    val visibleIndex = remember { mutableStateOf(0) }
    val visibleItem = items[visibleIndex.value % items.size]

    LaunchedEffect(true) {
        while (true) {
            delay(1000)
            coroutineScope.launch {
                scrollState.animateScrollTo(
                    (scrollState.value + 1) % items.size
                )
            }
        }
    }

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 4.dp, horizontal = 8.dp),
    ) {
        itemsIndexed(items){
            index, item ->
            Text(
                text = item.name,
                modifier = Modifier
                    .fillMaxWidth()
            )

        }
    }
}

@Composable
@Preview
fun CarouselRecipe() {
    CarouselRecipes(items = listDishTypes, modifier = Modifier.fillMaxWidth() )
}
