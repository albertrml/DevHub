package br.com.arml.devhub.ui.screen.user

import br.com.arml.devhub.model.entity.GitHubUser
import br.com.arml.devhub.utils.Response

data class UserState(
    val userDevHub: Response<GitHubUser> = Response.Loading
)
