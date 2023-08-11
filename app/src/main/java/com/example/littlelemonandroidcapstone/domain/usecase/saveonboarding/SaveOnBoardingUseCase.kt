package com.example.littlelemonandroidcapstone.domain.usecase.saveonboarding

import com.example.littlelemonandroidcapstone.data.repository.Repository


class SaveOnBoardingUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(
        isCompleted: Boolean,
        userFirstName: String,
        userLastName: String,
        userEmail: String
    ) {
        repository.saveOnBoardingState(
            isCompleted = isCompleted,
            userFirstName = userFirstName,
            userLastName = userLastName,
            userEmail = userEmail
        )
    }
}