package com.example.littlelemonandroidcapstone.di

import android.content.Context
import com.example.littlelemonandroidcapstone.data.repository.OnBoardingOperationImpl
import com.example.littlelemonandroidcapstone.data.repository.Repository
import com.example.littlelemonandroidcapstone.domain.repository.OnBoardingOperations
import com.example.littlelemonandroidcapstone.domain.usecase.UseCases
import com.example.littlelemonandroidcapstone.domain.usecase.getallmenuitems.GetAllMenuItemUseCase
import com.example.littlelemonandroidcapstone.domain.usecase.readonboarding.ReadOnBoardingUseCase
import com.example.littlelemonandroidcapstone.domain.usecase.removeonboarding.RemoveOnboardingUseCase
import com.example.littlelemonandroidcapstone.domain.usecase.saveonboarding.SaveOnBoardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideDataStoreOperation(
        @ApplicationContext context: Context
    ): OnBoardingOperations = OnBoardingOperationImpl(context = context)

    @Provides
    @Singleton
    fun provideUseCase(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            removeOnboardingUseCase = RemoveOnboardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository),
            getAllMenuItemUseCase = GetAllMenuItemUseCase(repository),
//            searchProductUseCase = SearchProductUseCase(repository)
        )
    }
}