package br.com.arml.devhub.ui.screen.component.userdatails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.arml.devhub.model.entity.GitHubRepository
import br.com.arml.devhub.model.mock.GitHubUserMock.mockDevs
import kotlin.random.Random

@Composable
fun UserRepositoriesComponent(
    modifier: Modifier = Modifier,
    repositories: List<GitHubRepository>,
){
    LazyColumn (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(repositories){ repo ->
            UserRepositoryComponent(repository = repo)
        }
    }
}

@Composable
fun UserRepositoryComponent(
    modifier: Modifier = Modifier,
    repository: GitHubRepository
) {
    OutlinedCard(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier
        ) {
            Box (
                modifier = Modifier.fillMaxWidth().background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primaryContainer,
                            MaterialTheme.colorScheme.primary
                        )
                    )
                )
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                    text = repository.name,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Text(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
                text = repository.description,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserRepositoriesComponentPreview(){
    val repositories by rememberSaveable {
        mutableStateOf(mockDevs[Random.nextInt(0,mockDevs.size-1)].repositories)
    }
    UserRepositoriesComponent(repositories = repositories)
}