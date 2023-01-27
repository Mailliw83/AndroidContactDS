package fr.isen.maignent.androidcontactds.models

import java.io.Serializable

data class Pictures(
    val large: String,
    val medium: String,
    val thumbnail: String
) : Serializable
