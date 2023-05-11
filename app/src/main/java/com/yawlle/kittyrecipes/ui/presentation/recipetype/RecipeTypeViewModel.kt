package com.yawlle.kittyrecipes.ui.presentation.recipetype

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yawlle.kittyrecipes.domain.model.RecipeType
import com.yawlle.kittyrecipes.domain.use_cases.GetRecipeByTypeUseCase
import com.yawlle.kittyrecipes.domain.use_cases.RecipesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeTypeViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getRecipeByTypeUseCase: GetRecipeByTypeUseCase
) : ViewModel(), DefaultLifecycleObserver {

    private val _recipeListState = MutableStateFlow(RecipeTypeState())
    val recipeState: StateFlow<RecipeTypeState> = _recipeListState.asStateFlow()


    fun getRecipeByCategory(recipeType: RecipeType?){
        viewModelScope.launch{
            try {
                getRecipeByTypeUseCase(recipeType?.APIname!!).let { recipes ->
                    _recipeListState.value = RecipeTypeState(
                        isLoading = false,
                        items = recipes,
                        errorMessage = null
                    )
                }
            } catch (e: Exception) {
                _recipeListState.value = RecipeTypeState(
                    isLoading = false,
                    items = emptyList(),
                    errorMessage = e.localizedMessage
                )
            }
        }
    }

}