package com.yawlle.kittyrecipes.domain.model

import com.yawlle.kittyrecipes.R
import java.io.Serializable

data class Recipe(
    val id: Int,
    val title: String,
    val cheap: Boolean,
    val cookingMinutes: Int,
    val image: String,
    val recipeTypes: List<RecipeType>,
    val instructions: String,
    val preparationMinutes: Int,
    val vegan: Boolean,
    val vegetarian: Boolean,
    val veryHealthy: Boolean,
    val veryPopular: Boolean,
    val healthScore: Double,
) : Serializable

val listRecipesMock = listOf(
    Recipe(
        1,
        "Bolo de cenoura com abacate e geleia de pimenta",
        true,
        60,
        "https://spoonacular.com/recipeImages/595736-556x370.jpg",
        listOf(RecipeType("Sobremesa", "dessert", R.drawable.dessert)),
        "1. Preaqueça o forno a 180 °C (temperatura média). Unte uma forma de bolo inglês com manteiga e polvilhe com farinha. Reserve. 2. Em uma tigela, misture a farinha, o fermento, o bicarbonato de sódio e o sal. Reserve. 3. Em uma tigela grande, bata o açúcar, a manteiga, os ovos, a cenoura e o extrato de baunilha até ficar homogêneo. 4. Adicione a mistura de farinha alternadamente com o leite, mexendo bem após cada adição. 5. Transfira a massa para a forma preparada e leve ao forno por 50 a 60 minutos ou até que um palito inserido no centro do bolo saia limpo. 6. Deixe esfriar por 10 minutos na forma. Em seguida, transfira para uma grade e deixe esfriar completamente. 7. Sirva.",
        30,
        true,
        true,
        true,
        true,
        123.2,
    ),
    Recipe(
        2,
        "Bolo de chocolate",
        true,
        60,
        "https://webknox.com/recipeImages/1747701-556x370.jpg",
        listOf(RecipeType("Sobremesa", "dessert", R.drawable.dessert)),
        "1. Preaqueça o forno a 180 °C (temperatura média). Unte uma forma de bolo inglês com manteiga e polvilhe com farinha. Reserve. 2. Em uma tigela, misture a farinha, o fermento, o bicarbonato de sódio e o sal. Reserve. 3. Em uma tigela grande, bata o açúcar, a manteiga, os ovos, a cenoura e o extrato de baunilha até ficar homogêneo. 4. Adicione a mistura de farinha alternadamente com o leite, mexendo bem após cada adição. 5. Transfira a massa para a forma preparada e leve ao forno por 50 a 60 minutos ou até que um palito inserido no centro do bolo saia limpo. 6. Deixe esfriar por 10 minutos na forma. Em seguida, transfira para uma grade e deixe esfriar completamente. 7. Sirva.",
        30,
        true,
        true,
        true,
        true,
        123.2
    ),
    Recipe(
        1,
        "Bolo de cenoura",
        true,
        60,
        "https://spoonacular.com/recipeImages/595736-556x370.jpg",
        listOf(RecipeType("Sobremesa", "dessert", R.drawable.dessert)),
        "1. Preaqueça o forno a 180 °C (temperatura média). Unte uma forma de bolo inglês com manteiga e polvilhe com farinha. Reserve. 2. Em uma tigela, misture a farinha, o fermento, o bicarbonato de sódio e o sal. Reserve. 3. Em uma tigela grande, bata o açúcar, a manteiga, os ovos, a cenoura e o extrato de baunilha até ficar homogêneo. 4. Adicione a mistura de farinha alternadamente com o leite, mexendo bem após cada adição. 5. Transfira a massa para a forma preparada e leve ao forno por 50 a 60 minutos ou até que um palito inserido no centro do bolo saia limpo. 6. Deixe esfriar por 10 minutos na forma. Em seguida, transfira para uma grade e deixe esfriar completamente. 7. Sirva.",
        30,
        true,
        true,
        true,
        true,
        123.2
    ),
    Recipe(
        2,
        "Bolo de chocolate",
        true,
        60,
        "https://webknox.com/recipeImages/1747701-556x370.jpg",
        listOf(RecipeType("Sobremesa", "dessert", R.drawable.dessert)),
        "1. Preaqueça o forno a 180 °C (temperatura média). Unte uma forma de bolo inglês com manteiga e polvilhe com farinha. Reserve. 2. Em uma tigela, misture a farinha, o fermento, o bicarbonato de sódio e o sal. Reserve. 3. Em uma tigela grande, bata o açúcar, a manteiga, os ovos, a cenoura e o extrato de baunilha até ficar homogêneo. 4. Adicione a mistura de farinha alternadamente com o leite, mexendo bem após cada adição. 5. Transfira a massa para a forma preparada e leve ao forno por 50 a 60 minutos ou até que um palito inserido no centro do bolo saia limpo. 6. Deixe esfriar por 10 minutos na forma. Em seguida, transfira para uma grade e deixe esfriar completamente. 7. Sirva.",
        30,
        true,
        true,
        true,
        true,
        123.2
    ),

    )