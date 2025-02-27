package com.map.address.domain.usecases

import com.map.address.data.room.entitiy.toDomain
import com.map.address.domain.model.GeoModel
import com.map.address.domain.repository.LocalRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class GetGeosListUseCase @Inject constructor(
    private val repo: LocalRepository
) {
    suspend operator fun invoke(): Flow<List<GeoModel>> {
        return withContext(Dispatchers.IO) {
            repo.getAllGeos().map { it.map { it.toDomain() } }
        }
    }
}