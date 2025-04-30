package br.com.arml.devhub.model.entity

import br.com.arml.devhub.model.source.network.dto.GitHubRepositoryDTO

data class GitHubRepository (
    val name: String,
    val fullName: String,
    val description: String
){
    companion object{
        fun from(gitHubRepo: GitHubRepositoryDTO): GitHubRepository{
            return GitHubRepository(
                name = gitHubRepo.name,
                fullName = gitHubRepo.fullName,
                description = gitHubRepo.description?:""
            )
        }
    }
}

/*val GitHubRepositorySaver: Saver<GitHubRepository, *> = listSaver(
    save = { gitHubRepository ->
        listOf(
            gitHubRepository.name,
            gitHubRepository.fullName,
            gitHubRepository.description
        )
    },
    restore = { list ->
        GitHubRepository(
            name = list[0],
            fullName = list[1],
            description = list[2]
        )
    }
)*/