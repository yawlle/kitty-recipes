package com.yawlle.kittyrecipes.data.repository

import com.yawlle.kittyrecipes.data.RecipeApi
import com.yawlle.kittyrecipes.data.dto.Recipe
import com.yawlle.kittyrecipes.domain.repository.RecipeRepository
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(private val recipeApi: RecipeApi) : RecipeRepository {

    override suspend fun getRandomRecipe(
        number: Int,
        tags: String
    ): Result<Recipe> =
        try {
            Result.success(recipeApi.getRandomRecipe(number, tags))
        } catch (e: Exception) {
            Result.failure(e)
        }
}