package com.anhhoang.myapplication.network

import com.anhhoang.myapplication.network.model.Instrument
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.http.GET
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create

object NetworkModule {
    val retrofit = retrofit2.Retrofit.Builder()
        .baseUrl("https://gist.githubusercontent.com/dns-mcdaid/b248c852b743ad960616bac50409f0f0/raw/6921812bfb76c1bea7868385adf62b7f447048ce/")
        .callFactory { OkHttpClient.Builder().build().newCall(it) }
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .build()

    val api: Api = retrofit.create()
}

interface Api {
    @GET("instruments.json")
    suspend fun getInstruments(): List<Instrument>

}