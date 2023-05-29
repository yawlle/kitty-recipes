package com.yawlle.kittyrecipes.ui.presentation.recipetype

import com.yawlle.kittyrecipes.domain.model.Recipe

data class RecipeState(
    val isLoading: Boolean = true,
    var recipe: Recipe? = null,
    val errorMessage: String? = null
)
