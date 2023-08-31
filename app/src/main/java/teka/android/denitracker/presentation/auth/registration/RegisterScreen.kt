package teka.android.denitracker.presentation.auth.registration

import androidx.compose.foundation.background
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import teka.android.denitracker.presentation.auth.AuthViewModel
import teka.android.denitracker.presentation.auth.home.HomeScreen
import teka.android.denitracker.ui.theme.buttonShapes
import teka.android.denitracker.ui.theme.md_theme_light_scrim
import teka.android.denitracker.ui.widgets.CustomButton
import teka.android.denitracker.ui.widgets.CustomOutlinedTextField
import teka.android.denitracker.ui.widgets.CustomPasswordTextField


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    navController: NavController,
    authViewModel: AuthViewModel = hiltViewModel()
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirmation by remember { mutableStateOf("") }
    val isRegisteredState = authViewModel.isRegistered.collectAsState()



    if (isRegisteredState.value) {
        HomeScreen()
    } else {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

        ) {
            CustomOutlinedTextField(
                value = name,
                label = "Name",
                onValueChanged =  { name = it },
            )

            CustomOutlinedTextField(
                value = email,
                label = "Email",
                onValueChanged =  { email = it },
            )

            CustomPasswordTextField(
                value = password,
                onValueChanged = { password = it },
                label = "Password",
            )
            CustomPasswordTextField(
                value = passwordConfirmation,
                onValueChanged = { passwordConfirmation = it },
                label = "Confirm Password"
            )
            Spacer(modifier = Modifier.height(26.dp))

            CustomButton(
                onClick = {
                    authViewModel.register(name, email, password, passwordConfirmation)
                },
                content = "Register"
            )
        }

    }
}
