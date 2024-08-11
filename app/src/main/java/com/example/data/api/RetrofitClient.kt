package com.example.data.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://shoppapp.liverpool.com.mx/appclienteservices/services/v3/")
        .addConverterFactory(MoshiConverterFactory.create(moshi)) // Usa MoshiConverterFactory
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}
