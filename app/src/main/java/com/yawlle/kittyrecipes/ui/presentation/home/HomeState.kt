package com.yawlle.kittyrecipes.ui.presentation.home

import com.yawlle.kittyrecipes.domain.model.Recipe

data class HomeState(
    val isLoading: Boolean = true,
    var items: List<Recipe> = emptyList(),
    val errorMessage: String? = null
)
