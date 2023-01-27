package fr.isen.maignent.androidcontactds.models

import java.io.Serializable

data class Location(
    val street: Streets,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    val coordinates: Coordinates,
    val timezone: TimeZone
) : Serializable
