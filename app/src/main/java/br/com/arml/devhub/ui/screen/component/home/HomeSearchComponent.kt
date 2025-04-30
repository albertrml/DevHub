package br.com.arml.devhub.ui.screen.component.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeSearchComponent(
    modifier: Modifier = Modifier,
    query: String,
    onChangeQuery: (String) -> Unit,
    onSearch: (String) -> Unit
){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Who is the dev you are looking for?",
            style = MaterialTheme.typography.titleMedium
        )
        TextField(
            value = query,
            onValueChange = onChangeQuery,
            modifier = Modifier,
            label = { Text("Username") },
            placeholder = { Text("Search") },
        )
        Button(
            onClick = { onSearch(query) },
            modifier = Modifier,
            content = { Text("Search") }
        )
    }
}