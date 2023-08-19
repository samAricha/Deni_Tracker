package teka.android.denitracker.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import teka.android.denitracker.entry.MainAppScreen
import teka.android.denitracker.ui.presentation.auth.UserState
import teka.android.denitracker.ui.presentation.auth.login.LoginScreen

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun RootNavGraph(
    navController: NavHostController,
    startDestination: String = To_MAIN_GRAPH_ROUTE
) {
    NavHost(navController = navController,
        startDestination = startDestination,
        route = ROOT_GRAPH_ROUTE
    ){


        authNavGraph(navController = navController)


        composable(route = To_MAIN_GRAPH_ROUTE){
            val vm = UserState.current
            val isLoggedInState by vm.isLoggedInState.collectAsState(initial = null)

            if (isLoggedInState != null) {
                if (isLoggedInState as Boolean) {
                    MainAppScreen()
                } else {
                    LoginScreen(navController)
                }
            } else {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

        }

    }
}