package br.com.arml.devhub.ui.screen.component.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import br.com.arml.devhub.R

@Composable
fun HomeHeaderComponent(
    modifier: Modifier = Modifier
) {
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
        Box(
            modifier = Modifier
                .size(125.dp)
                .align(Alignment.BottomCenter)
                .background(color = MaterialTheme.colorScheme.onBackground, shape = CircleShape)
        ) {}
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