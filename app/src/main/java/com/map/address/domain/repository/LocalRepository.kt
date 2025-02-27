package com.map.address.domain.repository

import com.map.address.data.room.entitiy.GeoEntity
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    suspend fun saveGeo(geo: GeoEntity)
    suspend fun deleteGeo(geo: GeoEntity)
    suspend fun getAllGeos(): Flow<List<GeoEntity>>
}