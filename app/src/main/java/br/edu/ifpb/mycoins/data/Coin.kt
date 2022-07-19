package br.edu.ifpb.mycoins.data

import com.google.gson.annotations.SerializedName

data class Coin(
    val id: String,
    val rank: Int,
    val symbol: String,
    @SerializedName("priceUsd")
    val price: String
)
