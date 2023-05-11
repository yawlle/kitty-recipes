package com.yawlle.kittyrecipes.data

import com.yawlle.kittyrecipes.data.dto.Recipe
import com.yawlle.kittyrecipes.data.dto.SearchRecipeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {
    @GET("recipes/random")
    suspend fun getRandomRecipe(
        @Query("number") number: Int,
        @Query("tags") tags: String
    ): Recipe

    @GET("recipes/complexSearch")
    suspend fun getRecipesByType(
        @Query("type") type: String,
    ): SearchRecipeResponse
}