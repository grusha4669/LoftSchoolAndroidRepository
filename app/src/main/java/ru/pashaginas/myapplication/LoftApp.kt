package ru.pashaginas.myapplication

import android.app.Application
import ru.pashaginas.myapplication.remote.MoneyApi
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory

class LoftApp : Application() {
    lateinit var moneyApi: MoneyApi
    override fun onCreate() {
        super.onCreate()
        configureRetrofit()
    }

    private fun configureRetrofit() {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://verdant-violet.glitch.me/") //todo
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
        moneyApi = retrofit.create(MoneyApi::class.java)
    }
}
