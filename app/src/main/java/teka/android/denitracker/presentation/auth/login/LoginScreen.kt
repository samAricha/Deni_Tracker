package teka.android.denitracker.presentation.auth.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import teka.android.denitracker.presentation.auth.AuthViewModel
import teka.android.denitracker.presentation.auth.home.HomeScreen
import teka.android.denitracker.ui.theme.TxtFieldShapes
import teka.android.denitracker.ui.theme.buttonShapes
import teka.android.denitracker.ui.widgets.CustomButton
import teka.android.denitracker.ui.widgets.CustomOutlinedTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController = rememberNavController(),
    authViewModel: AuthViewModel = hiltViewModel()
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val isLoggedInState = authViewModel.isLoggedIn.collectAsState()

    if (isLoggedInState.value) {
        HomeScreen()
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            CustomOutlinedTextField(
                value = email,
               label = "Email",
                error = "",
                onValueChanged =  { email = it },
            )
            CustomOutlinedTextField(
                value = password,
               label = "Password",
                error = "",
                onValueChanged =  { password = it },
            )
            Spacer(modifier = Modifier.height(26.dp))


            CustomButton(
                onClick = {
                    authViewModel.login(email, password)
                },
                content = "Login"
            )

        }
    }
}


