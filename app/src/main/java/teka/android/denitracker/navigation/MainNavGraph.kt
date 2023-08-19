package teka.android.denitracker.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import teka.android.denitracker.presentation.auth.AuthViewModel
import teka.android.denitracker.presentation.auth.registration.RegisterScreen
import teka.android.denitracker.data.repository.MyDataStoreRepository
import teka.android.denitracker.data.source.remote.retrofit.RetrofitProvider
import teka.android.denitracker.domain.authentication.AuthManager
import teka.android.denitracker.presentation.auth.home.HomeScreen
import teka.android.denitracker.presentation.auth.login.LoginScreen

@Composable
fun MainNavGraph(
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route,
        route = MAIN_GRAPH_ROUTE
    ) {


        composable(route = Screen.HomeScreen.route) {
            HomeScreen()
        }

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