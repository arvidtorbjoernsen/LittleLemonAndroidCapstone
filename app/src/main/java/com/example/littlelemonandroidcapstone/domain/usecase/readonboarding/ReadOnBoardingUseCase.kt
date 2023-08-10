package com.example.littlelemonandroidcapstone.domain.usecase.readonboarding

import com.example.littlelemonandroidcapstone.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(private val repository: Repository) {

    operator fun invoke(): Flow<Boolean> = repository.readOnBoardingState()


}