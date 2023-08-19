package teka.android.denitracker.ui.presentation.auth

import android.annotation.SuppressLint
import androidx.compose.runtime.compositionLocalOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import teka.android.denitracker.data.repository.MyDataStoreRepository
import teka.android.denitracker.domain.authentication.AuthManager
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authManager: AuthManager,
    private val dataStoreRepository: MyDataStoreRepository
) : ViewModel() {

    var isLoggedInState: Flow<Boolean> = dataStoreRepository.readLoggedInState()

    private var _isAuthenticated = MutableStateFlow(false)
    val isAuthenticated: StateFlow<Boolean> = _isAuthenticated

    private var _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn

    private val _isRegistered = MutableStateFlow(false)
    val isRegistered: StateFlow<Boolean> = _isRegistered

    init {
        viewModelScope.launch {
            _isAuthenticated.value = authManager.isAuthenticated()
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val success = authManager.login(email, password)
            _isLoggedIn.value = success
            if (success)dataStoreRepository.saveLoggedInState(isLoggedIn = true)
        }
    }

    fun register(name: String, email: String, password: String, passwordConfirmation: String) {
        viewModelScope.launch {
            val success = authManager.register(name, email, password, passwordConfirmation)
            _isRegistered.value = success
            if (success)dataStoreRepository.saveLoggedInState(isLoggedIn = true)
        }
    }

    fun logout() {
        viewModelScope.launch {
            authManager.clearAuthToken()
            dataStoreRepository.saveLoggedInState(false)
        }

    }


}

@SuppressLint("CompositionLocalNaming")
val UserState = compositionLocalOf<AuthViewModel> { error("User State Context Not Found!") }
