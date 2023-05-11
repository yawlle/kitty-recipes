package com.yawlle.kittyrecipes.domain.mapper

import com.yawlle.kittyrecipes.data.dto.SearchRecipeResponseItem
import com.yawlle.kittyrecipes.domain.model.SearchRecipe

fun SearchRecipeResponseItem.toSearchRecipe() =
    SearchRecipe(
        id = id,
        title = title,
        image = image,
        imageType = imageType
    )