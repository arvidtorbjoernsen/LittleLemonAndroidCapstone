package com.example.littlelemonandroidcapstone.domain.usecase.saveonboarding

import com.example.littlelemonandroidcapstone.data.repository.Repository


class SaveOnBoardingUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(isCompleted: Boolean) {
        repository.saveOnBoardingState(isCompleted = isCompleted)
    }
}