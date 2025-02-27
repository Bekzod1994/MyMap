package com.map.address.data.di

import android.content.Context
import androidx.room.Room
import com.map.address.data.room.AppDatabase
import com.map.address.data.room.dao.AddressDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext appContext: Context
    ): AppDatabase = Room.databaseBuilder(
        appContext, AppDatabase::class.java, "app_database"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideCardDao(database: AppDatabase): AddressDao {
        return database.addressDao()
    }
}