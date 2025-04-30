package br.com.arml.devhub.ui.screen.user

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
import br.com.arml.devhub.model.entity.GitHubUser
import br.com.arml.devhub.model.mock.GitHubUserMock.mockDevs

import br.com.arml.devhub.ui.component.AnimatedHorizontalDivider
import br.com.arml.devhub.ui.screen.component.userdatails.UserRepositoriesComponent
import br.com.arml.devhub.ui.screen.component.userdatails.UserHeaderComponent
import kotlin.random.Random

@Composable
fun UserScreen(
    modifier: Modifier = Modifier,
    user: GitHubUser
){

    Column(
        modifier = modifier
    ) {
        UserHeaderComponent(
            modifier = modifier,
            name = user.name,
            username = user.login,
            bio = user.bio,
            avatarUrl = user.avatarUrl
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

        UserRepositoriesComponent(
            modifier = Modifier.padding(horizontal = 12.dp),
            repositories = user.repositories
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UserScreenPreview(){
    UserScreen(user = mockDevs[Random.nextInt(0,mockDevs.size-1)])
}