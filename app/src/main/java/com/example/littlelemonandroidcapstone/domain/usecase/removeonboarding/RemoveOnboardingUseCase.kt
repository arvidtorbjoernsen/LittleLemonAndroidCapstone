package com.example.littlelemonandroidcapstone.domain.usecase.removeonboarding

import com.example.littlelemonandroidcapstone.data.repository.Repository

class RemoveOnboardingUseCase(private val repository: Repository) {
    suspend operator fun invoke(
        isCompleted: Boolean,
        userFirstName: String,
        userLastName: String,
        userEmail: String
    ) {
        repository.removeOnBoardingState(
            isCompleted = isCompleted,
            userFirstName = userFirstName,
            userLastName = userLastName,
            userEmail = userEmail
        )
    }
}