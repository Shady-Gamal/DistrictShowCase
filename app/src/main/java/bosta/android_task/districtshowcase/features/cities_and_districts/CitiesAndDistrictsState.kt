package bosta.android_task.districtshowcase.features.cities_and_districts

import bosta.android_task.domain.model.cities_and_districts.CitiesAndDistricts

data class CitiesAndDistrictsState(
    val isLoading:Boolean= false,
    val citiesAndDistricts: CitiesAndDistricts?=null,
    val error: String?=null
)
