package teka.android.denitracker.entry

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import teka.android.denitracker.R
import teka.android.denitracker.data.repository.MyDataStoreRepository
import teka.android.denitracker.navigation.MainNavGraph
import teka.android.denitracker.navigation.Screen
import teka.android.denitracker.ui.theme.PrimaryColor
import teka.android.denitracker.ui.theme.ReemKufi

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainAppScreen() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopBarComponent()
        },
        bottomBar = { BottomNavigationComponent(navController = navController) }
    ){

        Box(modifier = Modifier.padding(bottom = 60.dp)) {
            MainNavGraph(navController = navController)
        }

    }


}


@Composable
fun TopBarComponent(){
    TopAppBar(
        title = {
            Text(
                text = "Deni Tracker",
                fontFamily = ReemKufi,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.White
            )
        },
    )
}


sealed class BottomBarItem(
    val route: String,
    val iconRes: Int,
    val contentDescription: String,
    val label: String,
) {
    object RegistrationScreen : BottomBarItem(
        route = Screen.RegistrationScreen.route,
        iconRes = R.drawable.baseline_person_add_alt_1_24,
        contentDescription = "Register",
        label = "Register",
    )
    object LoginScreen : BottomBarItem(
        route = Screen.LoginScreen.route,
        iconRes = R.drawable.baseline_login_24,
        contentDescription = "Login",
        label = "Login"
    )
}


val bottomNavigationItems = listOf(
    BottomBarItem.RegistrationScreen,
    BottomBarItem.LoginScreen,
)
@Composable
fun BottomNavigationComponent(navController: NavController) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    val navBackStackEntry by navController.currentBackStackEntryAsState()


    fun getTint(selected: Boolean): Color = if (selected) {
        PrimaryColor
    } else {
        Color.Gray
    }

    NavigationBar(
        containerColor = MaterialTheme.colors.background
    ) {
        bottomNavigationItems.forEach { bottomItem ->
            NavigationBarItem(
                selected  = currentRoute == bottomItem.route,
                onClick = { navController.navigate(bottomItem.route) },
                icon = {
                    Icon(
                        painter = painterResource(bottomItem.iconRes),
                        contentDescription = bottomItem.contentDescription,
                        tint = getTint(currentRoute == bottomItem.route)
                    )
                },
                label = {
                    Text(
                        text = bottomItem.label,
                        color = getTint(currentRoute == bottomItem.route)
                    )
                }
            )
        }

    }
}




