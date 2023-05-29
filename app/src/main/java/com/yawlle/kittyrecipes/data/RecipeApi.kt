package com.yawlle.kittyrecipes.data

import com.yawlle.kittyrecipes.data.dto.RecipeResponse
import com.yawlle.kittyrecipes.data.dto.RecipeResponseItem
import com.yawlle.kittyrecipes.data.dto.SearchRecipeResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeApi {
    @GET("recipes/random")
    suspend fun getRandomRecipe(
        @Query("number") number: Int,
        @Query("tags") tags: String
    ): RecipeResponse

    @GET("recipes/complexSearch")
    suspend fun getRecipesByType(
        @Query("type") type: String,
    ): SearchRecipeResponse

    @GET("recipes/{id}/information")
    suspend fun getRecipeById(
        @Path("id") recipeId: Int,
    ): RecipeResponseItem
}