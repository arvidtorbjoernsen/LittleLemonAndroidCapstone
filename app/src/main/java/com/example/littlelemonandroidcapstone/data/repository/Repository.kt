package com.example.littlelemonandroidcapstone.data.repository

import com.example.littlelemonandroidcapstone.domain.model.MenuItem
import com.example.littlelemonandroidcapstone.domain.model.UserPreferences
import com.example.littlelemonandroidcapstone.domain.repository.LocalDataSource
import com.example.littlelemonandroidcapstone.domain.repository.OnBoardingOperations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataStore: OnBoardingOperations,
    private val localDataSource: LocalDataSource
) {

    suspend fun saveOnBoardingState(
        isCompleted: Boolean,
        userFirstName: String,
        userLastName: String,
        userEmail: String
    ) {
        dataStore.saveOnBoardingState(
            isCompleted = isCompleted,
            userFirstName = userFirstName,
            userLastName = userLastName,
            userEmail = userEmail
        )
    }

    suspend fun removeOnBoardingState(
        isCompleted: Boolean,
        userFirstName: String,
        userLastName: String,
        userEmail: String
    ) {
        dataStore.removeOnBoardingState(
            isCompleted = isCompleted,
            userFirstName = userFirstName,
            userLastName = userLastName,
            userEmail = userEmail
        )

    }

    fun readOnBoardingState(): Flow<UserPreferences> = dataStore.readOnBoardingState()

    fun getAllMenuItems(): Flow<List<MenuItem>> =
        localDataSource.getAllMenuItems().flowOn(Dispatchers.IO)

    suspend fun insertMenuItems(menuItems: List<MenuItem>) {
        localDataSource.insertMenuItems(menuItems)
    }
}