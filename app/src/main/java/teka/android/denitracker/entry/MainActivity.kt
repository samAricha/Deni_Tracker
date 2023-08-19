package teka.android.denitracker.entry

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint
import teka.android.denitracker.navigation.RootNavGraph
import teka.android.denitracker.presentation.auth.AuthViewModel
import teka.android.denitracker.presentation.auth.UserState
import teka.android.denitracker.presentation.splash.SplashViewModel
import teka.android.denitracker.ui.theme.DeniTrackerTheme
import teka.android.denitracker.ui.theme.PrimaryColor
import javax.inject.Inject

@ExperimentalAnimationApi
@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var splashViewModel: SplashViewModel

    private val userState by viewModels<AuthViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = PrimaryColor.toArgb()

        installSplashScreen().setKeepOnScreenCondition {
            Log.d("TAG2", splashViewModel.isLoading.value.toString())
            !splashViewModel.isLoading.value
        }


        super.onCreate(savedInstanceState)

        setContent {
            CompositionLocalProvider(UserState provides userState) {
                DeniTrackerTheme {
                    androidx.compose.material.Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = androidx.compose.material.MaterialTheme.colors.background
                    ) {
                        val startDestination by splashViewModel.startDestination
                        startDestination?.let {
                            RootNavGraph(
                                navController = rememberNavController(),
                                startDestination = it
                            )
                        }
                    }
                }
            }

        }
    }
}