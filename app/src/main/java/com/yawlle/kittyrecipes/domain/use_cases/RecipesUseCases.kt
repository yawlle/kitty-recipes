package com.yawlle.kittyrecipes.domain.use_cases

data class RecipesUseCases(
    val getRandomRecipeUseCase: GetRandomRecipeUseCase,
    val getRecipeByTypeUseCase: GetRecipeByTypeUseCase
)