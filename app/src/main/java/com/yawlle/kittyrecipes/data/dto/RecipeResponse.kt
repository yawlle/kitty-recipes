package com.yawlle.kittyrecipes.data.dto

import com.google.gson.annotations.SerializedName

data class RecipeResponse(
    @SerializedName("recipes")
    val recipes: List<RecipeResponseItem>
)