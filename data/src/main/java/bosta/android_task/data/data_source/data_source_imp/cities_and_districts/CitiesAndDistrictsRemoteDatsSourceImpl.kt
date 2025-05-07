package bosta.android_task.data.data_source.data_source_imp.cities_and_districts

import android.util.Log
import bosta.android_task.data.data_source.service.CitiesAndDistrictsService
import bosta.android_task.data.mappers.cities_and_districts.toDomain
import bosta.android_task.domain.model.Resource
import bosta.android_task.domain.model.cities_and_districts.CitiesAndDistricts
import bosta.android_task.domain.repository.cities_and_districts.CitiesAndDistrictsRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class CitiesAndDistrictsRemoteDatsSourceImpl @Inject constructor(
    private val citiesAndDistrictsService: CitiesAndDistrictsService
): CitiesAndDistrictsRemoteDataSource {
    override fun getAllCitiesAndDistricts(countryId: String): Flow<Resource<CitiesAndDistricts>> {
        return flow<Resource<CitiesAndDistricts>> {
            val citiesAndDistrictsResponse = citiesAndDistrictsService.getAllCitiesAndDistricts(countryId)
            emit(Resource.Success(citiesAndDistrictsResponse.toDomain()))
        }.onStart {
            emit(Resource.Loading())
        }.catch {
            emit(Resource.Error(it))
        }
    }
}