package com.example.littlelemonandroidcapstone.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.littlelemonandroidcapstone.data.local.dao.MenuItemDao
import com.example.littlelemonandroidcapstone.domain.model.MenuItem

@Database(entities = [MenuItem::class], version = 1, exportSchema = false)
abstract class MenuItemDatabase : RoomDatabase() {
    
    abstract fun menuItemDao(): MenuItemDao
}