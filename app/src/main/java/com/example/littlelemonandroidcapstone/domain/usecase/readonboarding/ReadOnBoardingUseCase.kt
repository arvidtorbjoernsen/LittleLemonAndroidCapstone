package com.example.littlelemonandroidcapstone.domain.usecase.readonboarding

import com.example.littlelemonandroidcapstone.data.repository.Repository
import com.example.littlelemonandroidcapstone.domain.model.UserPreferences
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(private val repository: Repository) {

    operator fun invoke(): Flow<UserPreferences> = repository.readOnBoardingState()


}