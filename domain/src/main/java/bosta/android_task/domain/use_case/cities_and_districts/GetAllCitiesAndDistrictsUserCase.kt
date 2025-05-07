package bosta.android_task.domain.use_case.cities_and_districts

import bosta.android_task.domain.model.Resource
import bosta.android_task.domain.model.cities_and_districts.CitiesAndDistricts
import bosta.android_task.domain.repository.cities_and_districts.CitiesAndDistrictsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCitiesAndDistrictsUserCase @Inject constructor(
    private val citiesAndDistrictsRepository: CitiesAndDistrictsRepository
) {
    operator fun invoke(countryId: String): Flow<Resource<CitiesAndDistricts>> = citiesAndDistrictsRepository.getAllCitiesAndDistricts(countryId)
}