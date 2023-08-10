package com.example.littlelemonandroidcapstone.domain.repository

import com.example.littlelemonandroidcapstone.domain.model.MenuItem
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    //    suspend fun insertMenuItem(products: List<MenuItem>)
    fun getAllMenuItems(): Flow<List<MenuItem>>
//    fun searchMenuItem(query: String): Flow<List<MenuItem>>
}