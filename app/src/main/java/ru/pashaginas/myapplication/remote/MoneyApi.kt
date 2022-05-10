package ru.pashaginas.myapplication.remote

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MoneyApi  {
    @GET("./items")
    fun getMoneyItems(@Query("type") type: String?): Single<String>?
}
