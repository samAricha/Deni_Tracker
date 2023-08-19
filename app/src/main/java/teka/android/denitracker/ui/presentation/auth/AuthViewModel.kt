package teka.android.customauth.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import teka.android.denitracker.domain.authentication.AuthManager

class AuthViewModel(private val authManager: AuthManager) : ViewModel() {

    private var _isAuthenticated = MutableStateFlow(false)
    val isAuthenticated: StateFlow<Boolean> = _isAuthenticated

    private var _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn

    private val _isRegistered = MutableStateFlow(false)
    val isRegistered: StateFlow<Boolean> = _isRegistered

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val success = authManager.login(email, password)
            _isLoggedIn.value = success
        }
    }

    fun register(name: String, email: String, password: String, passwordConfirmation: String) {
        viewModelScope.launch {
            val success = authManager.register(name, email, password, passwordConfirmation)
            _isRegistered.value = success
        }
    }

    fun logout() {
        viewModelScope.launch {
            authManager.clearAuthToken()
            _isAuthenticated.value = false
        }

    }

}