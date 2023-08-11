package com.example.littlelemonandroidcapstone.domain.model

data class UserPreferences(
    val isCompleted: Boolean,
    val userFirstName: String,
    val userLastName: String,
    val userEmail: String,
)
