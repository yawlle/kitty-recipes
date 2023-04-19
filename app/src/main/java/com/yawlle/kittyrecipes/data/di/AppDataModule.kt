package com.yawlle.kittyrecipes.data.di

import com.yawlle.kittyrecipes.data.RecipeApi
import com.yawlle.kittyrecipes.data.repository.RecipeRepositoryImpl
import com.yawlle.kittyrecipes.domain.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDataModule {

    private const val BASE_URL = "https://api.spoonacular.com/"
    @Provides
    @Singleton
    fun providesRecipeApi(): RecipeApi {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val originalRequest = chain.request()
                val requestWithApiKey = originalRequest.newBuilder()
                    .header("x-api-key", "e09653f8654747a5b321f119cce45d06")
                    .build()
                chain.proceed(requestWithApiKey)
            }
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(RecipeApi::class.java)
    }
}