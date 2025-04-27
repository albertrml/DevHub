package br.com.arml.devhub.ui.screen.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.arml.devhub.model.entity.DevUiSaver
import br.com.arml.devhub.model.mock.DevUiMock.mockDevs
import coil3.compose.AsyncImage

@Composable
fun HeaderRepository(
    modifier: Modifier = Modifier,
    name: String,
    username: String,
    resume: String,
    uriPhoto: String
){
    Column(modifier = modifier) {
        TopHeader(uriPhoto = uriPhoto)
        InfoHeader(
            modifier = modifier,
            name = name,
            username = username,
            resume = resume
        )
    }
}

@Composable
fun TopHeader(
    modifier: Modifier = Modifier,
    uriPhoto: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp), // altura da parte de fundo
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                bottomStart = 32.dp,
                bottomEnd = 32.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {}

        AsyncImage(
            model = uriPhoto,
            contentDescription = "Developer image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(125.dp) // Tamanho da foto
                .clip(CircleShape) // Redondo!!
                .border(
                    width = 4.dp,
                    color = MaterialTheme.colorScheme.background,
                    shape = CircleShape
                )
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun InfoHeader(modifier: Modifier, name: String, username: String, resume: String) {
    Column(
        modifier = modifier.fillMaxWidth(),
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
        Text(
            text = resume,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
fun HeaderRepositoryPreview(){
    val dev = rememberSaveable(saver = DevUiSaver) { mockDevs.first() }
    HeaderRepository(
        name = dev.name,
        username = dev.username,
        resume = dev.resume,
        uriPhoto = dev.uriPhoto
    )
}

