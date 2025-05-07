package bosta.android_task.districtshowcase.features.cities_and_districts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import bosta.android_task.districtshowcase.features.cities_and_districts.components.CitiesLazyColumn

@Composable
fun CitiesAndDistrictsScreen(
    viewModel: CitiesAndDistrictsViewModel= hiltViewModel()
) {
    Scaffold(Modifier.fillMaxSize()) { paddingValues->
        Column(modifier = Modifier.padding(paddingValues)) {
        CitiesLazyColumn(viewModel.citiesAndDistrictsState,
            searchTextValue = viewModel.searchText.collectAsState().value,
            onValueChange = { viewModel.setSearchText(it) }
        )
        }
    }
}