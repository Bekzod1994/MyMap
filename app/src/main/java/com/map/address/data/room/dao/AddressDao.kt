package com.map.address.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.map.address.data.room.entitiy.GeoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AddressDao {
    @Query("SELECT * FROM GeoEntity")
    fun getAllGeos(): Flow<List<GeoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveGeo(geo: GeoEntity)

    @Query("DELETE FROM GeoEntity WHERE id = :id")
    suspend fun deleteGeo(id: Int)
}