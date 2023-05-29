package com.yawlle.kittyrecipes.domain.use_cases

import com.yawlle.kittyrecipes.domain.mapper.toRecipe
import com.yawlle.kittyrecipes.domain.repository.RecipeRepository
import javax.inject.Inject

class GetRecipeByIdUseCase @Inject constructor(
    private val repository: RecipeRepository
) {

    suspend operator fun invoke(recipeId: Int) =
        repository.getRecipeById(recipeId).getOrThrow().toRecipe()

}