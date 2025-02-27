package com.map.address.data.di

import com.map.address.data.repo.LocalRepositoryImpl
import com.map.address.domain.repository.LocalRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface LocalModule {
    @Binds
    @Singleton
    fun bindLocalRepository(localRepository: LocalRepositoryImpl): LocalRepository
}