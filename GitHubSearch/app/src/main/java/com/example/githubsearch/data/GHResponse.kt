package com.example.githubsearch.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GHResponse (
    @SerialName("total_count")
    val totalCount: Int,
    val items: List<Data>,

)


