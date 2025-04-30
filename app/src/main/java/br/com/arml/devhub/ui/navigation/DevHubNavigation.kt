package br.com.arml.devhub.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.arml.devhub.ui.screen.home.HomeScreen
import br.com.arml.devhub.ui.screen.user.UserScreen


@Composable
fun DevHubNavigation (
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = HomeScreenDestination.route,
        modifier = modifier,
        enterTransition = { slideInHorizontally(initialOffsetX = { it },animationSpec = tween(300))  },
        exitTransition = { slideOutHorizontally(targetOffsetX = { -it },animationSpec = tween(300)) },
        popEnterTransition = { slideInHorizontally(initialOffsetX = { -it },animationSpec = tween(300)) },
        popExitTransition = { slideOutHorizontally(targetOffsetX = { it },animationSpec = tween(300)) }
    ){
        composable(route = HomeScreenDestination.route){
            HomeScreen(
                modifier = modifier,
                navigateToUserScreen = { username ->
                    navController.navigate("${UserScreenDestination.route}/$username"){
                        popUpTo(HomeScreenDestination.route){ saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
        composable(
            route = UserScreenDestination.routeWithArgs,
            arguments = UserScreenDestination.arguments,
            deepLinks = UserScreenDestination.deepLinks
        ){ navBackStackEntry ->
            val username = navBackStackEntry
                .arguments?.getString(UserScreenDestination.gitHubUsernmeArg)?:""
            UserScreen(
                modifier = modifier,
                username = username,
                navigateBack = { navController.navigateUp() },
            )
        }
    }
}