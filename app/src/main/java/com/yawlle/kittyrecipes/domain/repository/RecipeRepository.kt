package com.yawlle.kittyrecipes.domain.repository

import com.yawlle.kittyrecipes.data.dto.Recipe

interface RecipeRepository {
    suspend fun getRandomRecipe(
        number: Int,
        tags: String
    ): Result<Recipe>
}