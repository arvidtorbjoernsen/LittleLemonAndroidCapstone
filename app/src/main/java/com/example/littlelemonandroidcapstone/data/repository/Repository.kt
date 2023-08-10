package com.example.littlelemonandroidcapstone.data.repository

import com.example.littlelemonandroidcapstone.domain.model.MenuItem
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

    suspend fun saveOnBoardingState(isCompleted: Boolean) {
        dataStore.saveOnBoardingState(isCompleted = isCompleted)
    }

    suspend fun removeOnBoardingState(isCompleted: Boolean) {
        dataStore.removeOnBoardingState(isCompleted = isCompleted)
    }

    fun readOnBoardingState(): Flow<Boolean> = dataStore.readOnBoardingState()

    fun getAllMenuItems(): Flow<List<MenuItem>> =
        localDataSource.getAllMenuItems().flowOn(Dispatchers.IO)
}