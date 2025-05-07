package bosta.android_task.domain.repository.cities_and_districts

import bosta.android_task.domain.model.Resource
import bosta.android_task.domain.model.cities_and_districts.CitiesAndDistricts
import kotlinx.coroutines.flow.Flow

interface CitiesAndDistrictsRepository{
    fun getAllCitiesAndDistricts(countryId: String): Flow<Resource<CitiesAndDistricts>>
}

interface CitiesAndDistrictsRemoteDataSource{
    fun getAllCitiesAndDistricts(countryId: String): Flow<Resource<CitiesAndDistricts>>
}