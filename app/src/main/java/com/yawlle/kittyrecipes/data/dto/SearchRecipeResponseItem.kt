package com.yawlle.kittyrecipes.data.dto

import com.google.gson.annotations.SerializedName

data class SearchRecipeResponseItem(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("image")
    val image: String = "",
    @SerializedName("imageType")
    val imageType: String = "",
)