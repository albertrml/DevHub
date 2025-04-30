package br.com.arml.devhub.ui.screen.component.userdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.arml.devhub.model.entity.GitHubUserSaver
import br.com.arml.devhub.model.mock.GitHubUserMock.mockDevs
import br.com.arml.devhub.ui.screen.component.common.AvatarProfileComponent

@Composable
fun UserHeaderComponent(
    modifier: Modifier = Modifier,
    name: String,
    username: String,
    bio: String,
    avatarUrl: String
){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AvatarProfileComponent(imageUrl = avatarUrl)
        UserDetailsComponent(
            modifier = modifier.align(Alignment.CenterHorizontally),
            name = name,
            username = username,
            resume = bio
        )
    }
}

@Composable
fun UserDetailsComponent(modifier: Modifier, name: String, username: String, resume: String) {
    Column(
        modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = username,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.padding(6.dp))
        Text(
            text = resume,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun UserHeaderComponentPreview(){
    val dev = rememberSaveable(saver = GitHubUserSaver) { mockDevs.first() }
    UserHeaderComponent(
        name = dev.name,
        username = dev.login,
        bio = dev.bio,
        avatarUrl = dev.avatarUrl
    )
}

