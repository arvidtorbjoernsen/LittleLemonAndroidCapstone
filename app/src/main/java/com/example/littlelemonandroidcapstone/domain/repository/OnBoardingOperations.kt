package com.example.littlelemonandroidcapstone.domain.repository

import android.media.session.MediaSessionManager.RemoteUserInfo
import kotlinx.coroutines.flow.Flow

interface OnBoardingOperations {
    suspend fun saveOnBoardingState(isCompleted: Boolean)
    suspend fun saveUserInfo(userInfo: RemoteUserInfo)
    suspend fun removeOnBoardingState(isCompleted: Boolean)
    fun readOnBoardingState(): Flow<Boolean>
}