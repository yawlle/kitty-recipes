package com.yawlle.kittyrecipes.domain.use_cases

import com.yawlle.kittyrecipes.domain.mapper.toRecipe
import com.yawlle.kittyrecipes.domain.repository.RecipeRepository
import javax.inject.Inject

class GetRandomRecipeUseCase @Inject constructor(
    private val repository: RecipeRepository
) {

    suspend operator fun invoke(number: Int, tags: String) =
        repository.getRandomRecipe(number, tags).getOrThrow().recipes
            .map {
                it.toRecipe()
            }

}