package com.example.littlelemonandroidcapstone.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.littlelemonandroidcapstone.util.Constants.MENU_ITEM_DATABASE_TABLE

@Entity(tableName = MENU_ITEM_DATABASE_TABLE)
data class MenuItem(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val image: String,
    val category: String
)