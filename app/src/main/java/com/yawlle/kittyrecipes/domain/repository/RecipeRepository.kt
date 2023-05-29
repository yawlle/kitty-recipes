package com.yawlle.kittyrecipes.domain.repository

import com.yawlle.kittyrecipes.data.dto.RecipeResponse
import com.yawlle.kittyrecipes.data.dto.RecipeResponseItem
import com.yawlle.kittyrecipes.data.dto.SearchRecipeResponse

interface RecipeRepository {
    suspend fun getRandomRecipe(
        number: Int,
        tags: String
    ): Result<RecipeResponse>

    suspend fun getRecipesByType(
        type: String
    ): Result<SearchRecipeResponse>

    suspend fun getRecipeById(
        recipeId: Int
    ): Result<RecipeResponseItem>
}