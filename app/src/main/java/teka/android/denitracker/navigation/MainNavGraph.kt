package teka.android.denitracker.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import teka.android.customauth.presentation.AuthViewModel
import teka.android.customauth.presentation.registration.RegisterScreen
import teka.android.denitracker.data.repository.MyDataStoreRepository
import teka.android.denitracker.data.source.remote.retrofit.RetrofitProvider
import teka.android.denitracker.domain.authentication.AuthManager
import teka.android.denitracker.navigation.MAIN_GRAPH_ROUTE
import teka.android.denitracker.navigation.Screen
import teka.android.denitracker.ui.presentation.auth.home.HomeScreen
import teka.android.denitracker.ui.presentation.auth.login.LoginScreen

@Composable
fun MainNavGraph(
    navController: NavHostController,
    dataStoreRepository: MyDataStoreRepository
) {
    val authService = RetrofitProvider.createAuthService()
    val authManager = AuthManager(authService, dataStoreRepository)
    val authViewModel = AuthViewModel(authManager)

    NavHost(
        navController = navController,
        startDestination = Screen.RegistrationScreen.route,
        route = MAIN_GRAPH_ROUTE
    ) {

        composable(route = Screen.LoginScreen.route) {
            LoginScreen(authViewModel = authViewModel)
        }

        composable(route = Screen.RegistrationScreen.route) {
            RegisterScreen(authViewModel = authViewModel)
        }

        composable(route = Screen.HomeScreen.route) {
            HomeScreen(authViewModel = authViewModel)
        }

    }
}