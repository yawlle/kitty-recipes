package com.yawlle.kittyrecipes.ui.presentation.recipetype

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yawlle.kittyrecipes.domain.model.Recipe
import com.yawlle.kittyrecipes.domain.model.RecipeType
import com.yawlle.kittyrecipes.domain.use_cases.GetRecipeByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val getRecipeByIdUseCase: GetRecipeByIdUseCase,
) : ViewModel(), DefaultLifecycleObserver {

    private val _recipeState = MutableStateFlow(RecipeState())
    val recipeState: StateFlow<RecipeState> = _recipeState.asStateFlow()

    fun getRecipeById(recipeId: String?) {
        viewModelScope.launch {
            try {
                getRecipeByIdUseCase(recipeId = recipeId?.toInt()!!).let { recipe ->
                    _recipeState.value = RecipeState(
                        isLoading = false,
                        recipe = recipe,
                        errorMessage = null
                    )
                }
            } catch (e: Exception) {
                _recipeState.value = RecipeState(
                    isLoading = false,
                    recipe = null,
                    errorMessage = e.localizedMessage
                )
            }
        }
    }


}