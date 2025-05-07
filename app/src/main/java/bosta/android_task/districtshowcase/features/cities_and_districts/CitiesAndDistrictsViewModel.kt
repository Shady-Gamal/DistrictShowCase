package bosta.android_task.districtshowcase.features.cities_and_districts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bosta.android_task.districtshowcase.util.Constants
import bosta.android_task.domain.model.Resource
import bosta.android_task.domain.model.cities_and_districts.CitiesAndDistricts
import bosta.android_task.domain.use_case.cities_and_districts.FilterCitiesByNameUseCase
import bosta.android_task.domain.use_case.cities_and_districts.GetAllCitiesAndDistrictsUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CitiesAndDistrictsViewModel @Inject constructor(
    private val getAllCitiesAndDistrictsUserCase: GetAllCitiesAndDistrictsUserCase,
    private val filterCitiesByNameUseCase: FilterCitiesByNameUseCase
): ViewModel() {
    private val _searchText: MutableStateFlow<String> =
        MutableStateFlow("")
    val searchText: StateFlow<String> = _searchText

    var citiesAndDistrictsState by mutableStateOf(CitiesAndDistrictsState())

    private var _citiesAndDistrictsStateFullList:CitiesAndDistricts?=null

    init {
        getAllCitiesAndDistricts()
        filterCitiesByNameDebounceInitialization()
    }

    private fun getAllCitiesAndDistricts(){
        viewModelScope.launch {
            getAllCitiesAndDistrictsUserCase.invoke(Constants.EGYPT_COUNTRY_ID).collect{
                when (it){
                    is Resource.Loading -> citiesAndDistrictsState = citiesAndDistrictsState.copy(
                        isLoading = true
                    )
                    is Resource.Success -> {citiesAndDistrictsState = citiesAndDistrictsState.copy(
                        isLoading = false,
                        citiesAndDistricts = it.data
                    )
                        _citiesAndDistrictsStateFullList = it.data
                    }
                    is Resource.Error -> citiesAndDistrictsState = citiesAndDistrictsState.copy(
                        isLoading = false,
                        error = it.throwable?.message
                    )

                }
            }
        }


    }

    fun setSearchText(searchText:String){
        _searchText.value = searchText
    }


    private fun filterCitiesByNameDebounceInitialization(){
        viewModelScope.launch {
           _searchText.debounce(500).collectLatest {text->
               val searchResult = _citiesAndDistrictsStateFullList?.let { filterCitiesByNameUseCase(text, it) }
               citiesAndDistrictsState = citiesAndDistrictsState.copy(
                   citiesAndDistricts = searchResult
               )
           }
        }
    }
}