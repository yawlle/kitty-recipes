package com.yawlle.kittyrecipes.ui.presentation

import com.yawlle.kittyrecipes.domain.model.RecipeType
import kotlin.random.Random

fun getRandomDishTypes(list: List<RecipeType>): RecipeType {
    return list[Random.nextInt(list.size)]
}

