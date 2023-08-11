package com.example.littlelemonandroidcapstone.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.littlelemonandroidcapstone.domain.model.UserPreferences
import com.example.littlelemonandroidcapstone.domain.repository.OnBoardingOperations
import com.example.littlelemonandroidcapstone.util.Constants.USER_EMAIL
import com.example.littlelemonandroidcapstone.util.Constants.USER_FIRST_NAME
import com.example.littlelemonandroidcapstone.util.Constants.USER_IS_ONBOARDED
import com.example.littlelemonandroidcapstone.util.Constants.USER_LAST_NAME
import com.example.littlelemonandroidcapstone.util.Constants.USER_PREFERENCES
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_PREFERENCES)

class OnBoardingOperationsImpl(context: Context) : OnBoardingOperations {

    private object PreferencesKeys {
        val onBoardingKey = booleanPreferencesKey(USER_IS_ONBOARDED)
        val firstNameKey = stringPreferencesKey(USER_FIRST_NAME)
        val lastNameKey = stringPreferencesKey(USER_LAST_NAME)
        val emailKey = stringPreferencesKey(USER_EMAIL)
    }

    private val dataStore = context.dataStore

    override suspend fun saveOnBoardingState(
        isCompleted: Boolean,
        userFirstName: String,
        userLastName: String,
        userEmail: String
    ) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.onBoardingKey] = isCompleted
            preferences[PreferencesKeys.firstNameKey] = userFirstName
            preferences[PreferencesKeys.lastNameKey] = userLastName
            preferences[PreferencesKeys.emailKey] = userEmail

        }
    }

    override suspend fun removeOnBoardingState(
        isCompleted: Boolean,
        userFirstName: String,
        userLastName: String,
        userEmail: String
    ) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.onBoardingKey] = isCompleted
            preferences[PreferencesKeys.firstNameKey] = userFirstName
            preferences[PreferencesKeys.lastNameKey] = userLastName
            preferences[PreferencesKeys.emailKey] = userEmail
        }
    }

    override fun readOnBoardingState(): Flow<UserPreferences> = dataStore.data.map { preferences ->
        val isCompleted = preferences[PreferencesKeys.onBoardingKey] ?: false
        val userFirstName = preferences[PreferencesKeys.firstNameKey] ?: ""
        val userLastName = preferences[PreferencesKeys.lastNameKey] ?: ""
        val userEmail = preferences[PreferencesKeys.emailKey] ?: ""

        UserPreferences(isCompleted, userFirstName, userLastName, userEmail)
    }


}