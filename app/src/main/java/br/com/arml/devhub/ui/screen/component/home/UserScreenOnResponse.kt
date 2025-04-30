package br.com.arml.devhub.ui.screen.component.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.arml.devhub.R
import br.com.arml.devhub.model.entity.GitHubUser
import br.com.arml.devhub.ui.component.AnimatedHorizontalDivider
import br.com.arml.devhub.ui.screen.component.userdetails.UserHeaderComponent
import br.com.arml.devhub.ui.screen.component.userdetails.UserRepositoriesComponent

@Composable
fun UserScreenOnSuccess(
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

@Composable
fun UserScreenOnLoading(
    modifier: Modifier = Modifier
){
    Box(modifier = modifier.fillMaxSize()) {
        UserHeaderComponent(
            modifier = modifier,
            name = "",
            username = "",
            bio = "",
            avatarUrl = ""
        )
        CircularProgressIndicator(
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun UserScreenOnLoadingPreview(){
    UserScreenOnFailure(modifier = Modifier, exception = Exception("Teste"))
}

@Composable
fun UserScreenOnFailure(
    modifier: Modifier = Modifier,
    exception: Exception
){
    Box(modifier = modifier.fillMaxSize()) {
        UserHeaderComponent(
            modifier = modifier,
            name = "",
            username = "",
            bio = "",
            avatarUrl = ""
        )
        Text(
            modifier = Modifier
                .align(Alignment.Center),
            text = exception.message?:"Unknown Failure!",
            style = MaterialTheme.typography.headlineLarge
        )
    }
}