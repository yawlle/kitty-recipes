package com.yawlle.kittyrecipes.data.dto

import com.google.gson.annotations.SerializedName

data class RecipeResponseItem(
    @SerializedName("aggregateLikes")
    val aggregateLikes: Int = 0,
    @SerializedName("analyzedInstructions")
    val analyzedInstructions: List<AnalyzedInstruction>? = listOf(),
    @SerializedName("cheap")
    val cheap: Boolean = false,
    @SerializedName("cookingMinutes")
    val cookingMinutes: Int = 0,
    @SerializedName("creditsText")
    val creditsText: String = "",
    @SerializedName("cuisines")
    val cuisines: List<String>? = listOf(),
    @SerializedName("dairyFree")
    val dairyFree: Boolean = false,
    @SerializedName("diets")
    val diets: List<String>? = listOf(),
    @SerializedName("dishTypes")
    val dishTypes: List<String>? = listOf(),
    @SerializedName("extendedIngredients")
    val extendedIngredients: List<ExtendedIngredient>? = listOf(),
    @SerializedName("gaps")
    val gaps: String = "",
    @SerializedName("glutenFree")
    val glutenFree: Boolean = false,
    @SerializedName("healthScore")
    val healthScore: Double = 0.0,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("image")
    val image: String = "",
    @SerializedName("imageType")
    val imageType: String = "",
    @SerializedName("instructions")
    val instructions: String? = "",
    @SerializedName("license")
    val license: String = "",
    @SerializedName("lowFodmap")
    val lowFodmap: Boolean = false,
    @SerializedName("occasions")
    val occasions: List<String>? = emptyList(),
    @SerializedName("originalId")
    val originalId: String? = null,
    @SerializedName("preparationMinutes")
    val preparationMinutes: Int? = 0,
    @SerializedName("pricePerServing")
    val pricePerServing: Double = 0.0,
    @SerializedName("readyInMinutes")
    val readyInMinutes: Int = 0,
    @SerializedName("servings")
    val servings: Int = 0,
    @SerializedName("sourceName")
    val sourceName: String = "",
    @SerializedName("sourceUrl")
    val sourceUrl: String = "",
    @SerializedName("spoonacularScore")
    val spoonacularScore: Double = 0.0,
    @SerializedName("spoonacularSourceUrl")
    val spoonacularSourceUrl: String = "",
    @SerializedName("summary")
    val summary: String = "",
    @SerializedName("sustainable")
    val sustainable: Boolean = false,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("vegan")
    val vegan: Boolean = false,
    @SerializedName("vegetarian")
    val vegetarian: Boolean = false,
    @SerializedName("veryHealthy")
    val veryHealthy: Boolean = false,
    @SerializedName("veryPopular")
    val veryPopular: Boolean = false,
    @SerializedName("weightWatcherSmartPoints")
    val weightWatcherSmartPoints: Int = 0,
)

data class AnalyzedInstruction(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("steps")
    val steps: List<Step>? = listOf()
)

data class ExtendedIngredient(
    @SerializedName("aisle")
    val aisle: String = "",
    @SerializedName("amount")
    val amount: Double = 0.0,
    @SerializedName("consistency")
    val consistency: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("image")
    val image: String = "",
    @SerializedName("measures")
    val measures: Measures = Measures(),
    @SerializedName("meta")
    val meta: List<String>? = emptyList(),
    @SerializedName("name")
    val name: String = "",
    @SerializedName("nameClean")
    val nameClean: String = "",
    @SerializedName("original")
    val original: String = "",
    @SerializedName("originalName")
    val originalName: String = "",
    @SerializedName("unit")
    val unit: String = ""
)

data class Step(
    @SerializedName("equipment")
    val equipment: List<Equipment>? = listOf(),
    @SerializedName("ingredients")
    val ingredients: List<Ingredient>? = listOf(),
    @SerializedName("length")
    val length: Length = Length(),
    @SerializedName("number")
    val number: Int = 0,
    @SerializedName("step")
    val step: String = ""
)

data class Equipment(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("image")
    val image: String = "",
    @SerializedName("localizedName")
    val localizedName: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("temperature")
    val temperature: Temperature = Temperature()
)

data class Ingredient(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("image")
    val image: String = "",
    @SerializedName("localizedName")
    val localizedName: String = "",
    @SerializedName("name")
    val name: String = ""
)

data class Length(
    @SerializedName("number")
    val number: Int = 0,
    @SerializedName("unit")
    val unit: String = ""
)

data class Temperature(
    @SerializedName("number")
    val number: Double = 0.0,
    @SerializedName("unit")
    val unit: String = ""
)

data class Measures(
    @SerializedName("metric")
    val metric: Metric = Metric(),
    @SerializedName("us")
    val us: Us = Us()
)

data class Metric(
    @SerializedName("amount")
    val amount: Double = 0.0,
    @SerializedName("unitLong")
    val unitLong: String = "",
    @SerializedName("unitShort")
    val unitShort: String = ""
)

data class Us(
    @SerializedName("amount")
    val amount: Double = 0.0,
    @SerializedName("unitLong")
    val unitLong: String = "",
    @SerializedName("unitShort")
    val unitShort: String = ""
)