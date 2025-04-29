package br.com.arml.devhub

import br.com.arml.devhub.model.repository.DevHubRepository
import br.com.arml.devhub.model.source.network.DevHubApiService
import br.com.arml.devhub.model.source.network.dto.GitHubRepositoryDTO
import br.com.arml.devhub.model.source.network.dto.GitHubUserDTO
import br.com.arml.devhub.utils.Response
import coil3.network.HttpException
import coil3.network.NetworkResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.io.IOException

class DevHubRepositoryTest {

    private val service = mockk<DevHubApiService>()
    private lateinit var repository: DevHubRepository

    @Before
    fun setUp() {
        repository = DevHubRepository(service)
    }

    @Test
    fun`should emit Success when service returns GitHubUser from getUserWithRepos`() = runTest{
        val username = "albertrml"
        val userDTO = GitHubUserDTO(
            id = 1,
            login = "albertrml",
            name = "Albert",
            bio = "Desenvolvedor",
            avatarUrl = "Avatar.jpg "
        )
        val reposDTO = listOf(
            GitHubRepositoryDTO(
                id = 1,
                name = "repo1",
                fullName = "albertrml/repo1",
                description = "description1",
            ),
            GitHubRepositoryDTO(
                id = 2,
                name = "repo2",
                fullName = "albertrml/repo1",
                description = "description1",
            )
        )

        coEvery { service.getUser(username) } returns userDTO
        coEvery { service.getRepositories(username) } returns reposDTO

        repository.getUserWithRepos(username)
            .collect { response ->
                when(response){
                    is Response.Success -> {
                        assertEquals(userDTO.name, response.result.name)
                        assertEquals(userDTO.bio, response.result.bio)
                        assertEquals(userDTO.avatarUrl, response.result.avatarUrl)
                        assertEquals(reposDTO.size,response.result.repositories.size)
                        response.result.repositories.forEachIndexed { index, repository ->
                            assert(repository.name == reposDTO[index].name)
                            assert(repository.fullName == reposDTO[index].fullName)
                            assert(repository.description == reposDTO[index].description)
                        }
                    }
                    is Response.Loading -> assertTrue("Loading is expected", true)
                    is Response.Failure -> {
                        assertTrue(
                            "Should not reach here",
                            false
                        )
                    }
                }
            }

    }

    @Test
    fun `should emit Failure with HttpException from getUserWithRepos when user doesn't exist`() = runTest {
        val username = "nonexistentuser"
        coEvery { service.getUser(username) } throws HttpException(NetworkResponse(404))
        repository.getUserWithRepos(username)
            .collect { response ->
                when(response){
                    is Response.Success -> assertTrue("Failure is expected", false)
                    is Response.Loading -> assertTrue("Loading is expected", true)
                    is Response.Failure -> {
                        assertTrue(response.exception is HttpException)
                        assertEquals(
                            HttpException(NetworkResponse(404)).message,
                            response.exception.message)
                    }
                }
            }
    }

    @Test
    fun `should emit Failure with IOException from getUserWithRepos when network fails`() = runTest {
        val username = "albertrml"
        coEvery { service.getUser(username) } throws IOException("No internet")
        coEvery { service.getRepositories(username) } returns emptyList()

        repository.getUserWithRepos(username)
            .collect { response ->
                when (response) {
                    is Response.Success -> assertTrue("Failure is expected", false)
                    is Response.Loading -> assertTrue("Loading is expected", true)
                    is Response.Failure -> {
                        assertTrue(response.exception is IOException)
                        assertEquals(
                            "No internet",
                            response.exception.message
                        )
                    }
                }
            }
    }
}