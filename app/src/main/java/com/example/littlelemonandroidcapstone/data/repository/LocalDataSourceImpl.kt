package com.example.littlelemonandroidcapstone.data.repository

import com.example.littlelemonandroidcapstone.data.local.MenuItemDatabase
import com.example.littlelemonandroidcapstone.domain.model.MenuItem
import com.example.littlelemonandroidcapstone.domain.repository.LocalDataSource
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl(menuItemDatabase: MenuItemDatabase) : LocalDataSource {

    private val menuItemDao = menuItemDatabase.menuItemDao()

    override fun getAllMenuItems(): Flow<List<MenuItem>> = menuItemDao.getAllMenuItems()
    override suspend fun insertMenuItems(menuItems: List<MenuItem>) =
        menuItemDao.insertMenuItems(menuItems)
}