
package com.example.githubsearch.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val login: String,
    @SerialName("avatar_url") val avatarUrl: String
)

