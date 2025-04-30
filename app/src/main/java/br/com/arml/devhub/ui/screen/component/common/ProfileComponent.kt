package br.com.arml.devhub.ui.screen.component.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.arml.devhub.R

import coil3.compose.AsyncImage

@Composable
fun AvatarProfileComponent(
    modifier: Modifier = Modifier,
    imageUrl: String
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp),
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                bottomStart = 32.dp,
                bottomEnd = 32.dp
            )
        ) {}
        ShowDeveloperImage(
            modifier = Modifier.align(Alignment.BottomCenter),
            imageUrl = imageUrl
        )
    }
}

@Composable
fun ShowDeveloperImage(
    modifier: Modifier = Modifier,
    imageUrl: String
){
    Box(
        modifier = modifier
            .size(125.dp)
            .background(color = MaterialTheme.colorScheme.onBackground, shape = CircleShape)
    ) {
        if (imageUrl.isNotBlank()){
            AsyncImage(
                model = imageUrl,
                contentDescription = "Developer image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(125.dp)
                    .clip(CircleShape)
                    .border(
                        width = 4.dp,
                        color = MaterialTheme.colorScheme.onBackground,
                        shape = CircleShape
                    )
                    .align(Alignment.BottomCenter)
            )
        }
        else{
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_user),
                contentDescription = "Developer image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(125.dp)
                    .clip(CircleShape)
                    .align(Alignment.BottomCenter)
            )
        }
    }
}

@Preview
@Composable
fun ShowDeveloperImagePreview() {
    AvatarProfileComponent(
        imageUrl = ""
    )
}