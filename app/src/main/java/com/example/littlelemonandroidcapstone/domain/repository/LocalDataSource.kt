package com.example.littlelemonandroidcapstone.domain.repository

import com.example.littlelemonandroidcapstone.domain.model.MenuItem
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun getAllMenuItems(): Flow<List<MenuItem>>
    suspend fun insertMenuItems(menuItems: List<MenuItem>)

}