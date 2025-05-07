package bosta.android_task.data.mappers.cities_and_districts

import bosta.android_task.data.model.cities_and_distrcits.CitiesAndDistrictsDTO
import bosta.android_task.data.model.cities_and_distrcits.CityItemDTO
import bosta.android_task.data.model.cities_and_distrcits.DistrictsItemDTO
import bosta.android_task.domain.model.cities_and_districts.CitiesAndDistricts
import bosta.android_task.domain.model.cities_and_districts.CityItem
import bosta.android_task.domain.model.cities_and_districts.DistrictsItem

fun CitiesAndDistrictsDTO.toDomain(): CitiesAndDistricts =
   CitiesAndDistricts(
    cities = cities?.map { it?.toDomain() },
        success = success,
        message = message)


fun CityItemDTO.toDomain(): CityItem =
    CityItem(
        cityOtherName,
        cityName,
        cityCode,
        districts?.map { it?.toDomain()},
        dropOffAvailability,
        cityCode,pickupAvailability)


fun DistrictsItemDTO.toDomain(): DistrictsItem =
    DistrictsItem(
        coverage,
        districtId,
        districtName,
        zoneOtherName,
        zoneId,
        dropOffAvailability,
        zoneName,
        districtOtherName,
        pickupAvailability,
        notAllowedBulkyOrders,
        isBusy
    )
