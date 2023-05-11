package com.yawlle.kittyrecipes.domain.use_cases

import com.yawlle.kittyrecipes.domain.mapper.toSearchRecipe
import com.yawlle.kittyrecipes.domain.repository.RecipeRepository
import javax.inject.Inject

class GetRecipeByTypeUseCase @Inject constructor(
    private val repository: RecipeRepository
) {

    suspend operator fun invoke(type: String) =
        repository.getRecipesByType(type).getOrThrow().results
            .map {
                it.toSearchRecipe()
            }

}