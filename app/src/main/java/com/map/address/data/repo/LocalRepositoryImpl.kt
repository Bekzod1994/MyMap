package com.map.address.data.repo

import com.map.address.data.room.dao.AddressDao
import com.map.address.data.room.entitiy.GeoEntity
import com.map.address.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val dao: AddressDao
) : LocalRepository {
    override suspend fun saveGeo(geo: GeoEntity) {
        dao.saveGeo(geo)
    }

    override suspend fun deleteGeo(geo: GeoEntity) {
        dao.deleteGeo(geo.id)
    }

    override suspend fun getAllGeos(): Flow<List<GeoEntity>> {
        return dao.getAllGeos()
    }
}