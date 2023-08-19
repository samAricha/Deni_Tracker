package teka.android.denitracker.navigation

const val MAIN_GRAPH_ROUTE = "main_graph_route"


sealed class Screen(val route: String) {
    object RegistrationScreen : Screen(route = "registration_screen")
    object LoginScreen : Screen(route = "login_screen")
    object HomeScreen : Screen(route = "home_screen")
}