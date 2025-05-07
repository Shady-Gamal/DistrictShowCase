package bosta.android_task.data.model.cities_and_distrcits

import com.google.gson.annotations.SerializedName

data class CitiesAndDistrictsDTO(

	@field:SerializedName("data")
	val cities: List<CityItemDTO?>? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class DistrictsItemDTO(

	@field:SerializedName("coverage")
	val coverage: String? = null,

	@field:SerializedName("districtId")
	val districtId: String? = null,

	@field:SerializedName("districtName")
	val districtName: String? = null,

	@field:SerializedName("zoneOtherName")
	val zoneOtherName: String? = null,

	@field:SerializedName("zoneId")
	val zoneId: String? = null,

	@field:SerializedName("dropOffAvailability")
	val dropOffAvailability: Boolean? = null,

	@field:SerializedName("zoneName")
	val zoneName: String? = null,

	@field:SerializedName("districtOtherName")
	val districtOtherName: String? = null,

	@field:SerializedName("pickupAvailability")
	val pickupAvailability: Boolean? = null,

	@field:SerializedName("notAllowedBulkyOrders")
	val notAllowedBulkyOrders: Boolean? = null,

	@field:SerializedName("isBusy")
	val isBusy: Boolean? = null
)

data class CityItemDTO(

	@field:SerializedName("cityOtherName")
	val cityOtherName: String? = null,

	@field:SerializedName("cityName")
	val cityName: String? = null,

	@field:SerializedName("cityCode")
	val cityCode: String? = null,

	@field:SerializedName("districts")
	val districts: List<DistrictsItemDTO?>? = null,

	@field:SerializedName("dropOffAvailability")
	val dropOffAvailability: Boolean? = null,

	@field:SerializedName("cityId")
	val cityId: String? = null,

	@field:SerializedName("pickupAvailability")
	val pickupAvailability: Boolean? = null
)
