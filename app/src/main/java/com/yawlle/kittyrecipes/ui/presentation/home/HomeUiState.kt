package com.yawlle.kittyrecipes.ui.presentation.home

import com.yawlle.kittyrecipes.domain.model.Recipe
import com.yawlle.kittyrecipes.ui.common.ScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeUiState {

    private val _screenState = MutableStateFlow<ScreenState>(ScreenState.Content)
    val screenState = _screenState.asStateFlow()

    private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
    val recipes = _recipes.asStateFlow()

    fun showLoading() {
        _screenState.value = ScreenState.Loading
    }

    fun showContent(recipesList: List<Recipe>) {
        _screenState.value = ScreenState.Content
        _recipes.value = recipesList
    }

    fun showError(message : String = "") {
        _screenState.value = ScreenState.Error(message)
    }

}