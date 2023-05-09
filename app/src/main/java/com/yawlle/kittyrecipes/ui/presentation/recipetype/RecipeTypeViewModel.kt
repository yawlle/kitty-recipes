package com.yawlle.kittyrecipes.ui.presentation.recipetype

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.yawlle.kittyrecipes.domain.model.RecipeType
import com.yawlle.kittyrecipes.domain.use_cases.GetRandomRecipeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeTypeViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getRandomRecipeUseCase: GetRandomRecipeUseCase
) : ViewModel(), DefaultLifecycleObserver {

    fun setData(recipeType: RecipeType?){
        Log.d("getData - recipeType", "$recipeType")
    }

}