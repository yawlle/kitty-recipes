package com.yawlle.kittyrecipes.domain.repository

import com.yawlle.kittyrecipes.data.dto.Recipe
import com.yawlle.kittyrecipes.data.dto.SearchRecipeResponse

interface RecipeRepository {
    suspend fun getRandomRecipe(
        number: Int,
        tags: String
    ): Result<Recipe>

    suspend fun getRecipesByType(
        type: String
    ): Result<SearchRecipeResponse>
}