package br.com.arml.devhub.model.source.network.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GitHubUserDTO(
    val id: Int,
    val login: String,
    val name: String?,
    val bio: String?,
    @Json(name = "avatar_url") val avatarUrl: String
)