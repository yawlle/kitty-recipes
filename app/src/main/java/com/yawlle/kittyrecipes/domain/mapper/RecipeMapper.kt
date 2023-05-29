package com.yawlle.kittyrecipes.domain.mapper

import com.yawlle.kittyrecipes.data.dto.RecipeResponseItem
import com.yawlle.kittyrecipes.domain.model.RecipeType
import com.yawlle.kittyrecipes.domain.model.Recipe

fun RecipeResponseItem.toRecipe() =
    Recipe(
        id = id,
        title = title,
        cheap = cheap,
        cookingMinutes = cookingMinutes,
        recipeTypes = getRecipeType(dishTypes ?: listOf()),
        preparationMinutes = preparationMinutes ?: 0,
        vegan = vegan,
        vegetarian = vegetarian,
        veryHealthy = veryHealthy,
        veryPopular = veryPopular,
        image = image,
        instructions = instructions ?: "",
        healthScore = healthScore
    )

fun getRecipeType(recipeTypes: List<String>): List<RecipeType> {
    return recipeTypes.map {
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
            "lunch" -> "Almoço"
            else -> it
        }
        val APIname = when (it) {
            "main course" -> "main_course"
            "appetizer" -> "appetizer"
            "dessert" -> "dessert"
            "salad" -> "salad"
            "bread" -> "bread"
            "breakfast" -> "breakfast"
            "soup" -> "soup"
            "drink" -> "drink"
            "sauce" -> "sauce"
            "marinade" -> "marinade"
            "fingerfood" -> "fingerfood"
            "snack" -> "snack"
            "main dish" -> "main_dish"
            else -> it
        }

        RecipeType(name, APIname)
    }
}
