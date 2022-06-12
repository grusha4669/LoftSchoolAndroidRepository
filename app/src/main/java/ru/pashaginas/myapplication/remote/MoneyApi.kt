package ru.pashaginas.myapplication.remote

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface MoneyApi  {
    @GET("./items")
    fun getMoneyItems(@Query("type") type: String?): Single<MoneyResponse> //auth token in params

    @POST("./items/add")
    @FormUrlEncoded
    fun postMoney(
        @Field("price") price: Int,
        @Field("name") name: String?,
        @Field("type") type: String?
    ): Completable
}
