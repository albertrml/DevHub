package br.com.arml.devhub.model.entity

import br.com.arml.devhub.model.source.network.dto.GitHubRepositoryDTO
import br.com.arml.devhub.model.source.network.dto.GitHubUserDTO

data class GitHubUser (
    val login: String,
    val name: String,
    val bio: String,
    val avatarUrl: String,
    val repositories: List<GitHubRepository>
){
    companion object{
        fun from(githubUser: GitHubUserDTO, repositories: List<GitHubRepositoryDTO>): GitHubUser{
            return GitHubUser(
                login = githubUser.login,
                name = githubUser.name?: "",
                bio = githubUser.bio?:"",
                avatarUrl = githubUser.avatarUrl,
                repositories = repositories.map { GitHubRepository.from(it) }
            )
        }
    }
}