package bosta.android_task.domain

import bosta.android_task.domain.model.cities_and_districts.CitiesAndDistricts
import bosta.android_task.domain.model.cities_and_districts.CityItem
import bosta.android_task.domain.use_case.cities_and_districts.FilterCitiesByNameUseCase
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class FilterCitiesByNameUseCaseTest {


    private lateinit var filterCitiesByNameUseCase: FilterCitiesByNameUseCase
    private lateinit var citiesAndDistricts: CitiesAndDistricts
    @Before
    fun setup(){
        filterCitiesByNameUseCase = FilterCitiesByNameUseCase()
        citiesAndDistricts = CitiesAndDistricts(
            listOf(
                CityItem(
                    null,"Alexandria",null,null,null,null,null
                ),
                CityItem(
                    null,"Cairo",null,null,null,null,null
                ),
                CityItem(
                    null,"Aswan",null,null,null,null,null
                ),
                CityItem(
                    null,"Giza",null,null,null,null,null
                ),
                CityItem(
                    null,"Dahab",null,null,null,null,null
                )
            ),null,null

        )

    }

    @Test
    fun filterList_filterListByGivenString_filteredListReturned(){
        val filteredList = filterCitiesByNameUseCase.invoke(
            "alex", citiesAndDistricts
        )
        Assert.assertEquals(filteredList.cities, listOf(CityItem(
            null,"Alexandria",null,null,null,null,null
        )))
    }
}