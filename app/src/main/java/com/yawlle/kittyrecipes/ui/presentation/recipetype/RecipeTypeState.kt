package com.yawlle.kittyrecipes.ui.presentation.recipetype

import com.yawlle.kittyrecipes.domain.model.SearchRecipe

data class RecipeTypeState(
    val isLoading: Boolean = true,
    var items: List<SearchRecipe> = emptyList(),
    val errorMessage: String? = null
)
