package com.example.littlelemonandroidcapstone.domain.usecase

import com.example.littlelemonandroidcapstone.domain.usecase.getallmenuitems.GetAllMenuItemUseCase
import com.example.littlelemonandroidcapstone.domain.usecase.readonboarding.ReadOnBoardingUseCase
import com.example.littlelemonandroidcapstone.domain.usecase.removeonboarding.RemoveOnboardingUseCase
import com.example.littlelemonandroidcapstone.domain.usecase.saveonboarding.SaveOnBoardingUseCase
import com.example.littlelemonandroidcapstone.domain.usecase.saveproductusecase.InsertProductsUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val removeOnboardingUseCase: RemoveOnboardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val getAllMenuItemUseCase: GetAllMenuItemUseCase,
    val insertProductsUseCase: InsertProductsUseCase
)
