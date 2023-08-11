package com.example.littlelemonandroidcapstone.domain.repository

import com.example.littlelemonandroidcapstone.domain.model.UserPreferences
import kotlinx.coroutines.flow.Flow

interface OnBoardingOperations {
    suspend fun saveOnBoardingState(
        isCompleted: Boolean,
        userFirstName: String,
        userLastName: String,
        userEmail: String
    )

    suspend fun removeOnBoardingState(
        isCompleted: Boolean,
        userFirstName: String,
        userLastName: String,
        userEmail: String
    )

    fun readOnBoardingState(): Flow<UserPreferences>
}