package bosta.android_task.data.repository.cities_and_districs

import bosta.android_task.domain.model.Resource
import bosta.android_task.domain.model.cities_and_districts.CitiesAndDistricts
import bosta.android_task.domain.repository.cities_and_districts.CitiesAndDistrictsRemoteDataSource
import bosta.android_task.domain.repository.cities_and_districts.CitiesAndDistrictsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CitiesAndDistrictsRepositoryImpl @Inject constructor(
    private val citiesAndDistrictsRemoteDataSource: CitiesAndDistrictsRemoteDataSource
): CitiesAndDistrictsRepository {
    override fun getAllCitiesAndDistricts(countryId: String): Flow<Resource<CitiesAndDistricts>> {
        return citiesAndDistrictsRemoteDataSource.getAllCitiesAndDistricts(countryId)
    }

}