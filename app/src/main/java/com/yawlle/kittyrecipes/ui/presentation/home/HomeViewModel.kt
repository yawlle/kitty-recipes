package com.yawlle.kittyrecipes.ui.presentation.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import com.yawlle.kittyrecipes.domain.use_cases.GetRandomRecipeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRandomRecipeUseCase: GetRandomRecipeUseCase
) : ViewModel(), DefaultLifecycleObserver {

    private val _recipeState = mutableStateOf(HomeState())
    val recipeState: MutableState<HomeState> = _recipeState

    fun getRandomRecipe() {

    }

}
