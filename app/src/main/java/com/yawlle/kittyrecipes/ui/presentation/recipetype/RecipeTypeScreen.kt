package com.yawlle.kittyrecipes.ui.presentation.recipetype

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.yawlle.kittyrecipes.domain.model.RecipeType
import com.yawlle.kittyrecipes.ui.component.TopAppBar
import com.yawlle.kittyrecipes.ui.presentation.shimmer.ListImageTitleShimmer
import com.yawlle.kittyrecipes.ui.theme.PrimaryColor
import com.yawlle.kittyrecipes.ui.theme.TertiaryColor

@Composable
fun RecipeTypeScreen(
    recipeType: RecipeType?,
    onBackClick: () -> Unit,
    navigateToRecipeScreen: (recipeId: Int) -> Unit,
    vm: RecipeTypeViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = recipeType) {
        vm.getRecipeByCategory(recipeType)
    }

    val listRecipe = vm.recipeState.collectAsState().value

    ListRecipeScreen(
        recipeType,
        listRecipe,
        navigateToRecipeScreen,
        onBackClick,
        modifier = Modifier.background(
            color = PrimaryColor
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ListRecipeScreen(
    recipeType: RecipeType?,
    listRecipeState: RecipeTypeState,
    navigateToRecipeScreen: (recipeId: Int) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier
) {
    Scaffold(topBar = {
        TopAppBar(recipeType?.name, onBackClick)
    }, content = {
        Column(
            modifier
                .padding(it)
                .background(color = PrimaryColor)
                .fillMaxHeight()
        ) {
            if (listRecipeState.isLoading) {
                ListImageTitleShimmer(
                    modifier = modifier
                )
            } else {
                LazyColumn(
                    modifier = modifier.padding(16.dp),
                    contentPadding = PaddingValues(horizontal = 3.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    itemsIndexed(listRecipeState.items) { index, item ->
                        Card(modifier = modifier
                            .clip(RoundedCornerShape(8.dp))
                            .fillMaxWidth()
                            .background(color = PrimaryColor)
                            .fillMaxHeight()
                            .clickable {
                                navigateToRecipeScreen(item.id)
                            }) {
                            Row(
                                modifier = modifier.fillMaxWidth()
                            ) {
                                AsyncImage(
                                    model = item.image,
                                    contentDescription = "Image Recipe",
                                    contentScale = ContentScale.Crop,
                                    modifier = modifier
                                        .clip(RoundedCornerShape(8.dp))
                                        .size(100.dp)
                                        .drawWithContent {
                                            drawContent()
                                        },
                                )
                                Text(
                                    text = item.title,
                                    fontSize = 21.sp,
                                    color = TertiaryColor,
                                    maxLines = 2,
                                    overflow = TextOverflow.Clip,
                                    modifier = modifier.padding(start = 8.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    })
}




