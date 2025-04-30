package br.com.arml.devhub.ui.screen.user

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.arml.devhub.ui.screen.component.home.UserScreenOnFailure
import br.com.arml.devhub.ui.screen.component.home.UserScreenOnLoading
import br.com.arml.devhub.ui.screen.component.home.UserScreenOnSuccess
import br.com.arml.devhub.utils.ShowResults

@Composable
fun UserScreen(
    modifier: Modifier = Modifier,
    username: String,
    navigateBack: () -> Unit = {},
){

    val viewModel = hiltViewModel<DevHubViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = username) {
        viewModel.onEvent(UserEvent.OnSearchByUsername(username = username))
    }

    state.userDevHub.ShowResults(
        successContent = { UserScreenOnSuccess(modifier = modifier, user = it) },
        loadingContent = { UserScreenOnLoading(modifier = modifier) },
        failureContent = { UserScreenOnFailure(modifier = modifier, exception = it) }
    )
}



@Preview(showBackground = true)
@Composable
fun UserScreenPreview(){
    UserScreen(username = "albertrml")
}