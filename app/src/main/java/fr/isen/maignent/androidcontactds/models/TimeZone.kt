package fr.isen.maignent.androidcontactds.models

import java.io.Serializable

data class TimeZone(
    val offset: String,
    val description: String
) : Serializable
