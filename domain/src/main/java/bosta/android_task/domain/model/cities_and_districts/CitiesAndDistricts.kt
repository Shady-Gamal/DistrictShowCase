package bosta.android_task.domain.model.cities_and_districts


data class CitiesAndDistricts(
	val cities: List<CityItem?>?,
	val success: Boolean?,
	val message: String?
)

data class DistrictsItem(
	val coverage: String?,
	val districtId: String?,
	val districtName: String?,
	val zoneOtherName: String?,
	val zoneId: String?,
	val dropOffAvailability: Boolean?,
	val zoneName: String?,
	val districtOtherName: String?,
	val pickupAvailability: Boolean?,
	val notAllowedBulkyOrders: Boolean?,
	val isBusy: Boolean?
)

data class CityItem(
	val cityOtherName: String?,
	val cityName: String?,
	val cityCode: String?,
	val districts: List<DistrictsItem?>?,
	val dropOffAvailability: Boolean?,
	val cityId: String?,
	val pickupAvailability: Boolean?,
)
