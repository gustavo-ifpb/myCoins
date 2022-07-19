package br.edu.ifpb.mycoins.api

import br.edu.ifpb.mycoins.data.CoinsListResponse
import retrofit2.http.GET

interface APIService {

    @GET("assets")
    suspend fun getCoins(): CoinsListResponse
}
