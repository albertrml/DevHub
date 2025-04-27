package br.com.arml.devhub.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.arml.devhub.R
import br.com.arml.devhub.model.entity.DevUi
import br.com.arml.devhub.model.mock.DevUiMock.mockDevs
import br.com.arml.devhub.ui.component.AnimatedHorizontalDivider
import br.com.arml.devhub.ui.screen.component.BodyRepository
import br.com.arml.devhub.ui.screen.component.HeaderRepository
import kotlin.random.Random

@Composable
fun RepositoriesScreen(
    modifier: Modifier = Modifier,
    dev: DevUi = mockDevs[Random.nextInt(0,mockDevs.size-1)]
){

    Column(
        modifier = modifier
    ) {
        HeaderRepository(
            modifier = modifier,
            name = dev.name,
            username = dev.username,
            resume = dev.resume,
            uriPhoto = dev.uriPhoto
        )

        Spacer(modifier = Modifier.padding(16.dp))

        Text(
            modifier = Modifier.padding(horizontal = 12.dp),
            text = stringResource(R.string.repositories_title),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        AnimatedHorizontalDivider(
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 12.dp),
            startColor = MaterialTheme.colorScheme.primary,
            endColor = MaterialTheme.colorScheme.primaryContainer,
            thickness = 4.dp
        )

        BodyRepository(
            modifier = Modifier.padding(horizontal = 12.dp),
            repositories = dev.repositories
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RepositoriesScreenPreview(){
    RepositoriesScreen()
}