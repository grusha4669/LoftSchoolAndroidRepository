package ru.pashaginas.loftmoney.remote

import com.google.gson.annotations.SerializedName

class MoneyResponse {
    @SerializedName("status")
    val status: String? = null

    @SerializedName("data")
    val moneyItemsList: List<MoneyRemoteItem>? = null
}