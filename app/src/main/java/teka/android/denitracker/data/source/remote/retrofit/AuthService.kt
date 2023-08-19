package teka.android.denitracker.data.source.remote.retrofit

import retrofit2.http.Body
import retrofit2.http.POST
import teka.android.denitracker.data.source.remote.retrofit.models.AuthResponse
import teka.android.denitracker.data.source.remote.retrofit.models.LoginRequest
import teka.android.denitracker.data.source.remote.retrofit.models.PersonInfoRequest
import teka.android.denitracker.data.source.remote.retrofit.models.RegisterRequest
import teka.android.denitracker.data.source.remote.retrofit.models.User

interface AuthService {

    @POST("register")
    suspend fun registration(
        @Body registerRequest: RegisterRequest
    ): AuthResponse

    @POST("login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): AuthResponse

    @POST("me")
    suspend fun getMeInfo(
        @Body personInfoRequest: PersonInfoRequest
    ): User
}