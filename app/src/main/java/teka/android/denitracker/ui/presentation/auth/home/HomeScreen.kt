package teka.android.denitracker.ui.presentation.auth.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import teka.android.customauth.presentation.AuthViewModel

@Composable
fun HomeScreen(authViewModel:AuthViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Authenticated Content")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { authViewModel.logout() }) {
            Text("Logout")
        }
    }
}