package com.yawlle.kittyrecipes.domain.mapper

import com.yawlle.kittyrecipes.data.dto.RecipeResponseItem
import com.yawlle.kittyrecipes.domain.model.DishType
import com.yawlle.kittyrecipes.domain.model.Recipe

fun RecipeResponseItem.toRecipe() =
    Recipe(
        id = id,
        title = title,
        cheap = cheap,
        cookingMinutes = cookingMinutes,
        dishTypes = getDishType(dishTypes ?: listOf()),
        preparationMinutes = preparationMinutes ?: 0,
        vegan = vegan,
        vegetarian = vegetarian,
        veryHealthy = veryHealthy,
        veryPopular = veryPopular,
        image = image,
        instructions = instructions ?: "",
    )

fun getDishType(dishTypes: List<String>): List<DishType> {
    return dishTypes.map {
        val name = when (it) {
            "main course" -> "Prato Principal"
            "appetizer" -> "Entrada"
            "dessert" -> "Sobremesa"
            "salad" -> "Salada"
            "bread" -> "Pão"
            "breakfast" -> "Café da Manhã"
            "soup" -> "Sopa"
            "drink" -> "Bebida"
            "sauce" -> "Molho"
            "marinade" -> "Tempero"
            "fingerfood" -> "Petisco"
            "snack" -> "Lanche"
            else -> it
        }
        DishType(name)
    }
}
