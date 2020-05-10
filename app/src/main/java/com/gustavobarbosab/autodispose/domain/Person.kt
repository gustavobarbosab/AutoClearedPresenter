package com.gustavobarbosab.autodispose.domain

import com.squareup.moshi.Json

data class Person(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "first_name") val firstName: String,
    @field:Json(name = "last_name") val lastName: String
) {
    val completeName
        get() = "$firstName $lastName"

    val avatarUrl
        get() = "https://api.adorable.io/avatar/$firstName"
}