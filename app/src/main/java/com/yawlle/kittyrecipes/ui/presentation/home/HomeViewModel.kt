package com.yawlle.kittyrecipes.ui.presentation.home

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yawlle.kittyrecipes.domain.model.listRecipeTypes
import com.yawlle.kittyrecipes.domain.use_cases.GetRandomRecipeUseCase
import com.yawlle.kittyrecipes.ui.presentation.Constants.COUNT_CAROUSEL
import com.yawlle.kittyrecipes.ui.presentation.getRandomDishTypes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRandomRecipeUseCase: GetRandomRecipeUseCase
) : ViewModel(), DefaultLifecycleObserver {

    private val _recipeState = MutableStateFlow(HomeState())
    val recipeState: StateFlow<HomeState> = _recipeState.asStateFlow()

   fun getRandomRecipe(dishType: String) {
        viewModelScope.launch {
            try {
                getRandomRecipeUseCase(COUNT_CAROUSEL, dishType).let { recipes ->
                    _recipeState.value = HomeState(
                        isLoading = false,
                        items = recipes,
                        errorMessage = null
                    )
                }
            } catch (e: Exception) {
                _recipeState.value = HomeState(
                    isLoading = false,
                    items = emptyList(),
                    errorMessage = e.localizedMessage
                )
            }
        }

    }
}
