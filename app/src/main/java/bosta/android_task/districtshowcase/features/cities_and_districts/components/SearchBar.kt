package bosta.android_task.districtshowcase.features.cities_and_districts.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import bosta.android_task.districtshowcase.R

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    searchTextValue: String,
    onValueChange: (String) -> Unit) {
    OutlinedTextField(modifier = modifier,
        value = searchTextValue
        , onValueChange = onValueChange,
        trailingIcon = {Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = null)},
        placeholder = { Text(text = stringResource(R.string.city_area))},
        maxLines = 1,
        shape = RoundedCornerShape(8.dp)
        )
}