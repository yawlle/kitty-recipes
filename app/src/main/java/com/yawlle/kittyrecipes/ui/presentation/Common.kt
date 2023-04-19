package com.yawlle.kittyrecipes.ui.presentation

import com.yawlle.kittyrecipes.domain.model.DishType
import kotlin.random.Random

fun getRandomDishTypes(list: List<DishType>): DishType {
    return list[Random.nextInt(list.size)]
}

