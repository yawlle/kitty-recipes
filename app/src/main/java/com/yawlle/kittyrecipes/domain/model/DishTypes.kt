package com.yawlle.kittyrecipes.domain.model

import com.yawlle.kittyrecipes.R

data class DishTypes(
    val name: String,
    val image: Int? = null
)

val listDishTypes = listOf(
    DishTypes(
        "Prato principal", R.drawable.main_course
    ),
    DishTypes(
        "Acompanhamento", R.drawable.side_dish
    ),
    DishTypes(
        "Sobremesa", R.drawable.dessert
    ),
    DishTypes(
        "Entrada", R.drawable.appetizer
    ),
    DishTypes(
        "Salada", R.drawable.salad
    ),
    DishTypes(
        "Pão", R.drawable.bread
    ),
    DishTypes(
        "Café da manhã", R.drawable.breakfast
    ),
    DishTypes(
        "Sopa", R.drawable.soup
    ),
    DishTypes(
        "Molho", R.drawable.sauce
    ),
    DishTypes(
        "Tempero", R.drawable.marinade
    ),
    DishTypes(
        "Petisco", R.drawable.finger_food
    ),
    DishTypes(
        "Lanche", R.drawable.snack
    ),
    DishTypes(
        "Bebida", R.drawable.drink
    )
)


val MAIN_COURSE = DishTypes("Prato principal", R.drawable.main_course)
val SIDE_DISH = DishTypes("Acompanhamento", R.drawable.side_dish)
val DESSERT = DishTypes("Sobremesa", R.drawable.dessert)
val APPETIZER = DishTypes("Entrada", R.drawable.appetizer)
val SALAD = DishTypes("Salada", R.drawable.salad)
val BREAD = DishTypes("Pão", R.drawable.bread)
val BREAKFAST = DishTypes("Café da manhã", R.drawable.breakfast)
val SOUP = DishTypes("Sopa", R.drawable.soup)
val SAUCE = DishTypes("Molho", R.drawable.sauce)
val MARINADE = DishTypes("Tempero", R.drawable.marinade)
val FINGERFOOD = DishTypes("Petisco", R.drawable.finger_food)
val SNACK = DishTypes("Lanche", R.drawable.snack)
val DRINK = DishTypes("Bebida", R.drawable.drink)