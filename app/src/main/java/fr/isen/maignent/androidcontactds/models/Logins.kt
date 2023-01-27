package fr.isen.maignent.androidcontactds.models

import java.io.Serializable

data class Logins(
    val uuid: String,
    val username: String,
    val password: String,
    val salt: String,
    val md5: String,
    val sha1: String,
    val sha256: String
)  : Serializable