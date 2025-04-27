package br.com.arml.devhub.model.mock

import br.com.arml.devhub.model.entity.DevUi
import br.com.arml.devhub.model.entity.RepositoryUi
import java.util.UUID
import kotlin.random.Random

object DevUiMock {

    val mockDevs: List<DevUi> = List(20) { index ->
        DevUi(
            uuid = UUID.randomUUID().toString(), // Unique ID
            name = "Dev Name ${index + 1}", // Unique name
            username = "devuser${index + 1}", // Unique username
            uriPhoto = "https://encrypted-tbn0.gstatic.com/images?q=" +
                       "tbn:ANd9GcSuih27jgJn34Mn-nFIbwbrwI4SwuiOCbyiEg&s",
            resume = "Resume for Dev ${index + 1}",
            repositories = createMockRepositories(index)
        )
    }

    private fun createMockRepositories(devIndex: Int): List<RepositoryUi> {
        val numberOfRepositories = Random.nextInt(4, 10) // Each dev has 1-10 repositories
        return List(numberOfRepositories) { repoIndex ->
            RepositoryUi(
                id = (devIndex * 100) + repoIndex, // Unique ID per repo
                name = "Repo ${devIndex + 1}-${repoIndex + 1}", // Unique name
                description = "Description for Repo ${devIndex + 1}-${repoIndex + 1}"
            )
        }
    }
}