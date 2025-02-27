package com.map.address.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.map.address.data.room.dao.AddressDao
import com.map.address.data.room.entitiy.GeoEntity

@Database(entities = [GeoEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun addressDao(): AddressDao
}