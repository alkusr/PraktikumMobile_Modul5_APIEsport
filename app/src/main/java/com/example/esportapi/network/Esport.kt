package com.example.esportapi.network

import com.squareup.moshi.Json

data class Esport(
    @Json(name = "title") val title: String,
    @Json(name = "thumb") val thumb: String,
    @Json(name = "desc") val desc :  String,
    @Json(name = "author") val author :  String,
    @Json(name = "tag") val tag :  String,
    @Json(name = "time") val time :  String
)