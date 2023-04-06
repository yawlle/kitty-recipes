package com.yawlle.kittyrecipes.ui.presentation.home

import com.yawlle.kittyrecipes.domain.model.DishTypes

data class HomeState(
    val isLoading: Boolean = false,
    val items: List<DishTypes> = emptyList(),
    val errorMessage: String? = null
)
