package br.com.arml.devhub.model.repository

import br.com.arml.devhub.model.entity.GitHubUser
import br.com.arml.devhub.model.source.network.DevHubApiService
import br.com.arml.devhub.utils.Response
import br.com.arml.devhub.utils.onResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DevHubRepository @Inject constructor(
    private val apiService: DevHubApiService
) {

    fun getUserWithRepos(username: String): Flow<Response<GitHubUser>> = onResponse {
        val userDTO = apiService.getUser(username)
        val repositoriesDTO = apiService.getRepositories(username)
        GitHubUser.from(userDTO, repositoriesDTO)
    }

}