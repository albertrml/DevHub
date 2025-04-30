package br.com.arml.devhub.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.arml.devhub.ui.screen.component.home.HomeHeaderComponent
import br.com.arml.devhub.ui.screen.component.home.HomeSearchComponent

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        HomeHeaderComponent(modifier = Modifier.align(Alignment.TopCenter))
        HomeSearchComponent(
            modifier = Modifier.align(Alignment.Center),
            query = "",
            onChangeQuery = {},
            onSearch = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}