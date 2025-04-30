package br.com.arml.devhub.model.mock

import br.com.arml.devhub.model.entity.GitHubRepository
import br.com.arml.devhub.model.entity.GitHubUser
import kotlin.random.Random

object GitHubUserMock {

    val mockDevs: List<GitHubUser> = List(20) { index ->
        GitHubUser(
            name = "Dev Name ${index + 1}", // Unique name
            login = "devuser${index + 1}", // Unique username
            avatarUrl = "https://encrypted-tbn0.gstatic.com/images?q=" +
                       "tbn:ANd9GcSuih27jgJn34Mn-nFIbwbrwI4SwuiOCbyiEg&s",
            bio = "Resume for Dev ${index + 1}",
            repositories = createMockRepositories(index)
        )
    }

    private fun createMockRepositories(devIndex: Int): List<GitHubRepository> {
        val numberOfRepositories = Random.nextInt(4, 10) // Each dev has 1-10 repositories
        return List(numberOfRepositories) { repoIndex ->
            GitHubRepository(
                name = "Repo ${devIndex + 1}-${repoIndex + 1}", // Unique name,
                fullName = "Full Name for Repo ${devIndex + 1}-${repoIndex + 1}",
                description = "Description for Repo ${devIndex + 1}-${repoIndex + 1}"
            )
        }
    }
}