package br.com.arml.devhub.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink

interface DevHubDestination {
    val route: String
}

object HomeScreenDestination: DevHubDestination{
    override val route = "home_screen"
}

object UserScreenDestination: DevHubDestination{
    override val route = "user_screen"
    const val gitHubUsernmeArg = "username_git_hub"
    val routeWithArgs = "$route/{$gitHubUsernmeArg}"
    val arguments = listOf(
        navArgument(gitHubUsernmeArg){
            type = NavType.StringType
        }
    )
    val deepLinks =listOf(
        navDeepLink {  uriPattern = "$route/{$gitHubUsernmeArg}" }
    )
}