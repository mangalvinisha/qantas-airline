package com.example.qantas.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class AirportData(
    @SerializedName("regionalAirport")
    val regionalAirport: Boolean = false,
    @SerializedName("eticketableAirport")
    val eticketableAirport: Boolean = false,
    @SerializedName("airportName")
    val airportName: String = "",
    @SerializedName("country")
    val country: Country,
    @SerializedName("internationalAirport")
    val internationalAirport: Boolean = false,
    @SerializedName("city")
    val city: City,
    @SerializedName("location")
    val location: Location,
    @SerializedName("airportCode")
    val airportCode: String = "",
    @SerializedName("domesticAirport")
    val domesticAirport: Boolean = false,
    @SerializedName("state")
    val state: State,
    @SerializedName("region")
    val region: Region,
    @SerializedName("onlineIndicator")
    val onlineIndicator: Boolean = false
) : Parcelable

@Parcelize
data class State(
    @SerializedName("stateCode")
    val stateCode: String = "",
    @SerializedName("stateName")
    val stateName: String = ""
) : Parcelable

@Parcelize
data class Country(
    @SerializedName("countryCode")
    val countryCode: String = "",
    @SerializedName("countryName")
    val countryName: String = ""
) : Parcelable


@Parcelize
data class Region(
    @SerializedName("regionCode")
    val regionCode: String = "",
    @SerializedName("regionName")
    val regionName: String = ""
) : Parcelable


@Parcelize
data class City(
    @SerializedName("timeZoneName")
    val timeZoneName: String = "",
    @SerializedName("cityName")
    val cityName: String = "",
    @SerializedName("cityCode")
    val cityCode: String = ""
) : Parcelable


@Parcelize
data class Location(
    @SerializedName("latitudeDirection")
    val latitudeDirection: String = "",
    @SerializedName("longitudeDirection")
    val longitudeDirection: String = "",
    @SerializedName("latitudeRadius")
    val latitudeRadius: Double = 0.0,
    @SerializedName("aboveSeaLevel")
    val aboveSeaLevel: Int = 0,
    @SerializedName("latitude")
    val latitude: Double = 0.0,
    @SerializedName("longitudeRadius")
    val longitudeRadius: Double = 0.0,
    @SerializedName("longitude")
    val longitude: Double = 0.0
) : Parcelable


