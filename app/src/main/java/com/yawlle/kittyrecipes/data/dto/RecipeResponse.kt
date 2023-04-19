package com.yawlle.kittyrecipes.data.dto

import com.google.gson.annotations.SerializedName

data class Recipe(
    @SerializedName("recipes")
    val recipes: List<RecipeResponseItem>
)