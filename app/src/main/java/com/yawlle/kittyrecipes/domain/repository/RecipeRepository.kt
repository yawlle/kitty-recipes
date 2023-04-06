package com.yawlle.kittyrecipes.domain.repository

import com.yawlle.kittyrecipes.data.dto.RecipeResponse

interface RecipeRepository {
    suspend fun getRandomRecipe(
        number: Int,
        tags: String
    ): Result<RecipeResponse>
}