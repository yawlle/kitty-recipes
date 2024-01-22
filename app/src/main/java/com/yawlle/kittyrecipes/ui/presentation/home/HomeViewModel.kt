package com.yawlle.kittyrecipes.ui.presentation.home

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yawlle.kittyrecipes.domain.model.listRecipeTypes
import com.yawlle.kittyrecipes.domain.use_cases.GetRandomRecipeUseCase
import com.yawlle.kittyrecipes.ui.presentation.Constants.COUNT_CAROUSEL
import com.yawlle.kittyrecipes.ui.presentation.errorMessage
import com.yawlle.kittyrecipes.ui.presentation.getRandomDishTypes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRandomRecipeUseCase: GetRandomRecipeUseCase
) : ViewModel(), DefaultLifecycleObserver {

    val uiState = HomeUiState()

    init {
        getRandomRecipe(getRandomDishTypes(listRecipeTypes).APIname)
    }

    private fun getRandomRecipe(dishType: String) {
        uiState.showLoading()
        viewModelScope.launch {
            try {
                getRandomRecipeUseCase(COUNT_CAROUSEL, dishType).let { recipes ->
                    uiState.showContent(recipes)
                }
            } catch (e: Exception) {
                uiState.showError()
            } catch (e: HttpException) {
                uiState.showError(e.errorMessage())
            }
        }
    }
}
