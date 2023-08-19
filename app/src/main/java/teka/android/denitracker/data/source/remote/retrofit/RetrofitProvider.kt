package teka.android.denitracker.data.source.remote.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object RetrofitProvider {
    private const val BASE_URL = "https://fd61-41-89-128-5.ngrok-free.app/api/"

    private fun provide(): Retrofit {
        val json = Json { ignoreUnknownKeys = true }//to ignore unkown keys

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(provideOkhttpClient())
            .addConverterFactory(json.asConverterFactory(
                "application/vnd.api+json".toMediaType()
            ))
            .build()
    }

    private fun provideOkhttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().also {
                it.level = HttpLoggingInterceptor.Level.BODY
            })
            .addInterceptor(HeaderInterceptor)
            .build()


    fun createAuthService(): AuthService {
        return provide().create(AuthService::class.java)
    }

}