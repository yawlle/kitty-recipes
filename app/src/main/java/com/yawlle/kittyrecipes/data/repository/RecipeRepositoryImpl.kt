package com.yawlle.kittyrecipes.data.repository

import com.yawlle.kittyrecipes.data.RecipeApi
import com.yawlle.kittyrecipes.data.dto.RecipeResponse
import com.yawlle.kittyrecipes.data.dto.RecipeResponseItem
import com.yawlle.kittyrecipes.data.dto.SearchRecipeResponse
import com.yawlle.kittyrecipes.domain.repository.RecipeRepository
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(private val recipeApi: RecipeApi) :
    RecipeRepository {

    override suspend fun getRandomRecipe(
        number: Int,
        tags: String
    ): Result<RecipeResponse> =
        try {
            Result.success(recipeApi.getRandomRecipe(number, tags))
        } catch (e: Exception) {
            Result.failure(e)
        }

    override suspend fun getRecipesByType(
        type: String
    ): Result<SearchRecipeResponse> =
        try {
            Result.success(recipeApi.getRecipesByType(type))
        } catch (e: Exception) {
            Result.failure(e)
        }

    override suspend fun getRecipeById(
        recipeId: Int
    ): Result<RecipeResponseItem> =
        try {
            Result.success(recipeApi.getRecipeById(recipeId))
        } catch (e: Exception) {
            Result.failure(e)
        }
}