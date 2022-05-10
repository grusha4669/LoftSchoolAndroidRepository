package ru.pashaginas.myapplication.remote

import com.google.gson.annotations.SerializedName

class MoneyRemoteItem {
    @SerializedName("id")
    val itemId: String? = null

    @SerializedName("name")
    val name: String? = null

    @SerializedName("price")
    val price = 0.0

    @SerializedName("type")
    val type: String? = null

    @SerializedName("date")
    val date: String? = null
}
