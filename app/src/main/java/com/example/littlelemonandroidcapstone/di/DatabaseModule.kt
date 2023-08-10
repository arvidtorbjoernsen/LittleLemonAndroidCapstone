package com.example.littlelemonandroidcapstone.di

import android.content.Context
import androidx.room.Room
import com.example.littlelemonandroidcapstone.data.local.MenuItemDatabase
import com.example.littlelemonandroidcapstone.data.repository.LocalDataSourceImpl
import com.example.littlelemonandroidcapstone.domain.repository.LocalDataSource
import com.example.littlelemonandroidcapstone.util.Constants.LITTLE_LEMON_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): MenuItemDatabase {
        return Room.databaseBuilder(
            context,
            MenuItemDatabase::class.java,
            LITTLE_LEMON_DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(
        database: MenuItemDatabase
    ): LocalDataSource {
        return LocalDataSourceImpl(database)
    }
}