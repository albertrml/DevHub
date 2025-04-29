package br.com.arml.devhub.model.source.network

import br.com.arml.devhub.model.source.network.dto.GitHubRepositoryDTO
import br.com.arml.devhub.model.source.network.dto.GitHubUserDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface DevHubApiService {
    @GET("users/{username}")
    suspend fun getUser(@Path("username") username: String): GitHubUserDTO

    @GET("users/{username}/repos")
    suspend fun getRepositories(@Path("username") username: String): List<GitHubRepositoryDTO>
}