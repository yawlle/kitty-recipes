package com.yawlle.kittyrecipes.domain.model

import com.yawlle.kittyrecipes.R

data class DishType(
    val name: String,
    val APIname: String? = null,
    val image: Int? = null
)

val listDishTypes = listOf(
    DishType(
        "Prato principal", "main_course", R.drawable.main_course
    ),
    DishType(
        "Acompanhamento", "side_dish", R.drawable.side_dish
    ),
    DishType(
        "Sobremesa", "dessert", R.drawable.dessert
    ),
    DishType(
        "Entrada", "appetizer", R.drawable.appetizer
    ),
    DishType(
        "Salada", "salad", R.drawable.salad
    ),
    DishType(
        "Pão", "bread", R.drawable.bread
    ),
    DishType(
        "Café da manhã", "breakfast", R.drawable.breakfast
    ),
    DishType(
        "Sopa", "soup", R.drawable.soup
    ),
    DishType(
        "Molho", "sauce", R.drawable.sauce
    ),
    DishType(
        "Tempero", "marinade", R.drawable.marinade
    ),
    DishType(
        "Petisco", "food", R.drawable.finger_food
    ),
    DishType(
        "Lanche", "snack", R.drawable.snack
    ),
    DishType(
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