package teka.android.denitracker.entry

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint
import teka.android.denitracker.ui.theme.DeniTrackerTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeniTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DeniTrackerTheme {
        Greeting("Android")
    }
}



//@ExperimentalAnimationApi
//@ExperimentalPagerApi
//@AndroidEntryPoint
//class MainActivity : ComponentActivity() {
//    @Inject
//    lateinit var splashViewModel: SplashViewModel
//
//    private val userState by viewModels<AuthViewModel>()
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        window.statusBarColor = PrimaryColor.toArgb()
//
//        installSplashScreen().setKeepOnScreenCondition {
//            Log.d("TAG2", splashViewModel.isLoading.value.toString())
//            !splashViewModel.isLoading.value
//        }
//
//
//        super.onCreate(savedInstanceState)
//
//        setContent {
//            CompositionLocalProvider(UserState provides userState) {
//                TekEventAndroidClientTheme {
//                    androidx.compose.material.Surface(
//                        modifier = Modifier.fillMaxSize(),
//                        color = androidx.compose.material.MaterialTheme.colors.background
//                    ) {
//                        val startDestination by splashViewModel.startDestination
//                        startDestination?.let {
//                            RootNavGraph(
//                                navController = rememberNavController(),
//                                startDestination = it
//                            )
//                        }
//                    }
//                }
//            }
//
//        }
//    }
//}