package com.map.address.domain.usecases

import com.map.address.domain.model.GeoModel
import com.map.address.domain.model.toEntity
import com.map.address.domain.repository.LocalRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class DeleteGeoUseCase @Inject constructor(
    private val repo: LocalRepository
) {
    suspend operator fun invoke(geoModel: GeoModel) {
        return withContext(Dispatchers.IO) {
            repo.deleteGeo(geoModel.toEntity())
        }
    }
}