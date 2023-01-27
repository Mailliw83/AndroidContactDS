package fr.isen.maignent.androidcontactds.models

import java.io.Serializable

data class Results(
    val results: Array<Contacts>
) : Serializable
