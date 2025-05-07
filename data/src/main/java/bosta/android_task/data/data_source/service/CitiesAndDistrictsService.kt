package bosta.android_task.data.data_source.service

import bosta.android_task.data.model.cities_and_distrcits.CitiesAndDistrictsDTO
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CitiesAndDistrictsService {
    @GET("cities/getAllDistricts")
    suspend fun getAllCitiesAndDistricts(@Query("countryId") countryId:String): CitiesAndDistrictsDTO
}