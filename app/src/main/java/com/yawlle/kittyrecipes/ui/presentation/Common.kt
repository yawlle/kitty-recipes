package com.yawlle.kittyrecipes.ui.presentation

import com.yawlle.kittyrecipes.domain.model.RecipeType
import org.json.JSONObject
import retrofit2.HttpException
import kotlin.random.Random

fun getRandomDishTypes(list: List<RecipeType>): RecipeType {
    return list[Random.nextInt(list.size)]
}

fun HttpException.errorMessage(): String {
    return try {
        val jObjError = JSONObject(response()!!.errorBody()!!.string())
        jObjError.getString("message")
    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }
}
