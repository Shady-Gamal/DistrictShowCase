package bosta.android_task.districtshowcase.features.cities_and_districts.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bosta.android_task.districtshowcase.R
import bosta.android_task.districtshowcase.features.cities_and_districts.CitiesAndDistrictsState
import bosta.android_task.districtshowcase.ui.theme.DistrictsBackground
import bosta.android_task.domain.model.cities_and_districts.DistrictsItem

@Composable
fun CitiesLazyColumn(
    citiesAndDistrictsState: CitiesAndDistrictsState,
    searchTextValue:String,
    onValueChange: (String)->Unit

) {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
    citiesAndDistrictsState.citiesAndDistricts?.cities?.let { cities ->
        LazyColumn(Modifier.fillMaxSize()) {
            item {
                Row(modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically) {
                Text(text = stringResource(R.string.choose_the_delivery_area),
                    fontWeight = FontWeight.W700,
                    fontSize = 24.sp)
                    Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = {

                }) {
                    Icon(painter = painterResource(id = R.drawable.ic_close), contentDescription = null)
                }
                }
            }
            item {
                SearchBar(
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    searchTextValue = searchTextValue,
                    onValueChange = onValueChange
                )
            }
            items(cities) { city ->
                var isCityExpanded by remember {
                    mutableStateOf(false)
                }
                Column {
                    city?.cityName?.let {
                        CityItem(cityName = it, isCityExpanded = isCityExpanded) {
                            isCityExpanded = !isCityExpanded
                        }
                    }
                    AnimatedVisibility(visible = isCityExpanded) {
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .background(DistrictsBackground)
                        ) {
                            city?.districts?.forEach { district ->
                                DistrictItem(districtsItem = district)
                            }
                        }
                    }
                }
            }
        }
    }

        if (citiesAndDistrictsState.isLoading) LoadingShimmer()
        citiesAndDistrictsState.error?.let {
            Text(text = it, color = Color.Red,
                fontSize = 36.sp)
        }
    }
}

@Composable
fun CityItem(
    modifier: Modifier = Modifier,
    cityName:String,
    isCityExpanded:Boolean,
    onCityClick:()->Unit) {

    val rotationState by animateFloatAsState(
        targetValue = if (isCityExpanded) 180f else 0f, label = "arrow"
    )
    Column(
        modifier
            .clickable {
                onCityClick()
            }) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)) {
        Text(text = cityName)
            Spacer(modifier = Modifier.weight(1f))
        Icon(painter = painterResource(id = R.drawable.ic_arrow_down), contentDescription = null,
            modifier = Modifier.rotate(rotationState))
        }
        Spacer(modifier = Modifier.weight(1f))
        HorizontalDivider(Modifier.fillMaxWidth())
    }
}

@Composable
fun DistrictItem(modifier: Modifier = Modifier,
                 districtsItem: DistrictsItem?) {
    Row(modifier = modifier.padding(8.dp)){
        districtsItem?.districtName?.let {districtName->
            Text(text = districtName)
        }
    }
}

@Composable
fun LoadingShimmer(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .padding(16.dp)) {
        Box(modifier= Modifier
            .fillMaxWidth()
            .height(80.dp)
            .shimmerEffect())
        Spacer(modifier = Modifier.height(16.dp))
        repeat(16){
            Box(modifier= Modifier
                .fillMaxWidth()
                .height(60.dp)
                .shimmerEffect())
            Spacer(modifier = Modifier.height(8.dp))
            
        }
    }
}