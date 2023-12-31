package teka.android.denitracker.domain.authentication

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import teka.android.denitracker.data.repository.MyDataStoreRepository
import teka.android.denitracker.data.source.remote.retrofit.AuthService
import teka.android.denitracker.data.source.remote.retrofit.RetrofitProvider
import teka.android.denitracker.data.source.remote.retrofit.models.LoginRequest
import teka.android.denitracker.data.source.remote.retrofit.models.RegisterRequest
import javax.inject.Inject

class AuthManager @Inject constructor(
    private val dataStoreRepository: MyDataStoreRepository
) {

    private val authService: AuthService = RetrofitProvider.createAuthService()


    suspend fun login(email: String, password: String): Boolean {
        val response = authService.login(LoginRequest(email, password))
        if (response.isSuccessful) {
            val token = response.data.accessToken
            saveAuthToken(token)
            return true
        }
        return false
    }

    suspend fun register(name: String, email: String, password: String, passwordConfirmation: String): Boolean {
        val response = authService.registration(RegisterRequest(name, email, password, passwordConfirmation))
        if (response.isSuccessful) {
            val token = response.data.accessToken
            saveAuthToken(token)
            return true
        }
        return false
    }

    private suspend fun saveAuthToken(token: String) = withContext(Dispatchers.IO) {
        dataStoreRepository.saveToken(token)
    }

    suspend fun getAuthToken(): String {
        return dataStoreRepository.getAccessToken.first()
    }

    suspend fun isAuthenticated(): Boolean{
        val isAuthenticated = dataStoreRepository.readLoggedInState()
        return isAuthenticated.first()
    }

    suspend fun clearAuthToken() {
        dataStoreRepository.saveToken("")
    }
}

