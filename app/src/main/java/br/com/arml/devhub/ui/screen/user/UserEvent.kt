package br.com.arml.devhub.ui.screen.user

sealed class UserEvent {
    data class OnSearchByUsername(val username: String): UserEvent()
}