package fr.isen.maignent.androidcontactds.models

import java.io.Serializable

data class Contacts(
    val gender: String,
    val name: Names,
    val location: Location,
    val email: String,
    val dob: Dobs,
    val registered: Registered,
    val phone: String,
    val cell: String,
    val id: Ids,
    val picture: Pictures,
    val nat: String
) : Serializable
