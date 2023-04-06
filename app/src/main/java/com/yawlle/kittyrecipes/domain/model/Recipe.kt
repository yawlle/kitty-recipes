package com.yawlle.kittyrecipes.domain.model

import com.yawlle.kittyrecipes.data.dto.ExtendedIngredient

data class Recipe(
    val id: Int,
    val title: String,
    val cheap: Boolean,
    val cookingMinutes: Int,
    val image: String,
    val dishTypes: List<DishTypes>,
    val instructions: String,
    val preparationMinutes: Int,
    val vegan: Boolean,
    val vegetarian: Boolean,
    val veryHealthy: Boolean,
    val veryPopular: Boolean,
)