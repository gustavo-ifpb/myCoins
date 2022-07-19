package br.edu.ifpb.mycoins.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {

    private const val BASE_URL = "https://api.coincap.io/v2/"
    private val apiService: APIService

    init {
        val okHttpClient = OkHttpClient.Builder().build()

        apiService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }

    suspend fun getCoins() = withContext(Dispatchers.IO) {
        apiService.getCoins()
    }
}
