package bosta.android_task.domain.use_case.cities_and_districts

import bosta.android_task.domain.model.cities_and_districts.CitiesAndDistricts
import javax.inject.Inject

class FilterCitiesByNameUseCase @Inject constructor() {

    operator fun invoke(
        searchText:String,
        citiesAndDistricts: CitiesAndDistricts) : CitiesAndDistricts{

        return citiesAndDistricts.copy(
            cities = citiesAndDistricts.cities?.filter {
                it?.cityName?.contains(searchText,true) == true
            }
        )
    }
}