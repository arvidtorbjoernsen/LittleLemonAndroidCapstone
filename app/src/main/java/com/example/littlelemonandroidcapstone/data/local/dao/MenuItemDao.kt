package com.example.littlelemonandroidcapstone.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.littlelemonandroidcapstone.domain.model.MenuItem
import kotlinx.coroutines.flow.Flow

@Dao
interface MenuItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMenuItems(products: List<MenuItem>)

    @Query("SELECT * FROM menu_item_table")
    fun getAllMenuItems(): Flow<List<MenuItem>>

    @Query("SELECT * FROM menu_item_table WHERE title LIKE '%' || :query || '%'")
    fun searchMenuItems(query: String): Flow<List<MenuItem>>

}