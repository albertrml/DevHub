package br.com.arml.devhub.model.source.network.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GitHubRepositoryDTO(
    val id: Int,
    val name: String,
    @Json(name = "full_name")
    val fullName: String,
    val description: String?,
)
