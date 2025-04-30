package br.com.arml.devhub.ui.screen.component.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.arml.devhub.ui.screen.component.common.AvatarProfileComponent


@Composable
fun HomeHeaderComponent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AvatarProfileComponent(imageUrl = "")
    }
}

@Preview
@Composable
fun HomeHeaderComponentPreview() {
    HomeHeaderComponent()
}