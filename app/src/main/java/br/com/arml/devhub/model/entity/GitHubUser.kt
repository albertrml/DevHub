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
    save = { devUi ->
        listOf(
            devUi.name,
            devUi.login,
            devUi.bio,
            devUi.avatarUrl,
            devUi.repositories
        )
    },
    restore = { list ->
        @Suppress("UNCHECKED_CAST")
        GitHubUser(
            list[0] as String,
            list[1] as String,
            list[2] as String,
            list[3] as String,
            list[5] as List<GitHubRepository>
        )
    }
)