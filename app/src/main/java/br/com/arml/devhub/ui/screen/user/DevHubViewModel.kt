package br.com.arml.devhub.ui.screen.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.arml.devhub.model.repository.DevHubRepository
import br.com.arml.devhub.utils.update
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DevHubViewModel @Inject constructor(
    private val repository: DevHubRepository,
) : ViewModel() {
    private val _state = MutableStateFlow(UserState())
    val state = _state.asStateFlow()


    fun onEvent(event: UserEvent) {
        when (event) {
            is UserEvent.OnSearchByUsername -> searchByUsername(event.username)
        }
    }

    private fun searchByUsername(username: String) {
        viewModelScope.launch {
            repository.getUserWithRepos(username).collect { result ->
                result.update(_state) { state, res ->
                    state.copy(userDevHub = res)
                }
            }
        }
    }

}