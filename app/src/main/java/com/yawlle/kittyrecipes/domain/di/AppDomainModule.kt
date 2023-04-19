package com.yawlle.kittyrecipes.domain.di

import com.yawlle.kittyrecipes.data.RecipeApi
import com.yawlle.kittyrecipes.data.repository.RecipeRepositoryImpl
import com.yawlle.kittyrecipes.domain.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object AppDomainModule {

    @Provides
    @ViewModelScoped
    fun provideRecipeRepository(
        api: RecipeApi
    ): RecipeRepository {
        return RecipeRepositoryImpl(api)
    }

}