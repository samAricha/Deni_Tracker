package teka.android.denitracker.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import teka.android.denitracker.presentation.auth.registration.RegisterScreen
import teka.android.denitracker.presentation.auth.login.LoginScreen


fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
){
    navigation(
        startDestination = Screen.LoginScreen.route,
        route = AUTH_GRAPH_ROUTE
    ){


        composable(
            route = Screen.LoginScreen.route
        ) {
            LoginScreen(navController = navController)
        }

        composable(
            route = Screen.RegistrationScreen.route
        ) {
            RegisterScreen(navController = navController)
        }

    }
}