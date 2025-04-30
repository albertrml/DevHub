package br.com.arml.devhub.model.entity

import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
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

val GitHubUserSaver: Saver<GitHubUser, *> = listSaver(
    save = { gitHubUser ->
        listOf(
            gitHubUser.login,
            gitHubUser.name,
            gitHubUser.bio,
            gitHubUser.avatarUrl,
            gitHubUser.repositories.map {
                listOf(it.name, it.fullName, it.description)
            }
        )
    },
    restore = { list ->
        @Suppress("UNCHECKED_CAST")
        GitHubUser(
            login = list[0] as String,
            name = list[1] as String,
            bio = list[2] as String,
            avatarUrl = list[3] as String,
            repositories = (list[4] as List<List<String>>).map {
                GitHubRepository(it[0], it[1], it[2])
            }
        )
    }
)