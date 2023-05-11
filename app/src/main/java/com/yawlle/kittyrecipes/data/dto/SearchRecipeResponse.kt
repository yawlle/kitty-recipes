package com.yawlle.kittyrecipes.data.dto

import com.google.gson.annotations.SerializedName

data class SearchRecipeResponse(
    @SerializedName("results")
    val results: List<SearchRecipeResponseItem>,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("number")
    val number: Int,
    @SerializedName("totalResults")
    val totalResults: Int
)