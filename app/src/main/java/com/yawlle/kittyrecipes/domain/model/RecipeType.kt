package com.yawlle.kittyrecipes.domain.model

import com.yawlle.kittyrecipes.R


data class RecipeType(
    val name: String,
    val APIname: String,
    val image: Int? = null
)

val listRecipeTypes = listOf(
    RecipeType(
        "Prato principal", "main_course", R.drawable.main_course
    ),
    RecipeType(
        "Acompanhamento", "side_dish", R.drawable.side_dish
    ),
    RecipeType(
        "Sobremesa", "dessert", R.drawable.dessert
    ),
    RecipeType(
        "Entrada", "appetizer", R.drawable.appetizer
    ),
    RecipeType(
        "Salada", "salad", R.drawable.salad
    ),
    RecipeType(
        "Pão", "bread", R.drawable.bread
    ),
    RecipeType(
        "Café da manhã", "breakfast", R.drawable.breakfast
    ),
    RecipeType(
        "Sopa", "soup", R.drawable.soup
    ),
    RecipeType(
        "Molho", "sauce", R.drawable.sauce
    ),
    RecipeType(
        "Tempero", "marinade", R.drawable.marinade
    ),
    RecipeType(
        "Petisco", "food", R.drawable.finger_food
    ),
    RecipeType(
        "Lanche", "snack", R.drawable.snack
    ),
    RecipeType(
        "Bebida", "drink", R.drawable.drink
    )
)


//val MAIN_COURSE = DishType("Prato principal", R.drawable.main_course)
//val SIDE_DISH = DishType("Acompanhamento", R.drawable.side_dish)
//val DESSERT = DishType("Sobremesa", R.drawable.dessert)
//val APPETIZER = DishType("Entrada", R.drawable.appetizer)
//val SALAD = DishType("Salada", R.drawable.salad)
//val BREAD = DishType("Pão", R.drawable.bread)
//val BREAKFAST = DishType("Café da manhã", R.drawable.breakfast)
//val SOUP = DishType("Sopa", R.drawable.soup)
//val SAUCE = DishType("Molho", R.drawable.sauce)
//val MARINADE = DishType("Tempero", R.drawable.marinade)
//val FINGERFOOD = DishType("Petisco", R.drawable.finger_food)
//val SNACK = DishType("Lanche", R.drawable.snack)
//val DRINK = DishType("Bebida", R.drawable.drink)