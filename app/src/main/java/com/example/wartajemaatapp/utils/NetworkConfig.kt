package com.example.wartajemaatapp.utils


import com.example.wartajemaatapp.BuildConfig
import com.example.wartajemaatapp.model.network.ApiServiceFinancialStatements
import com.example.wartajemaatapp.model.network.ApiServiceMain
import com.example.wartajemaatapp.model.network.ApiServiceSector
import com.example.wartajemaatapp.model.network.ApiServiceWeeklyWorship
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig {
    private val gson: Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    private val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder().build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val apiServiceSector: ApiServiceSector by lazy {
        retrofit.create(ApiServiceSector::class.java)
    }

    val apiServiceFinancialStatements: ApiServiceFinancialStatements by lazy {
        retrofit.create(ApiServiceFinancialStatements::class.java)
    }

    val apiServiceMain: ApiServiceMain by lazy {
        retrofit.create(ApiServiceMain::class.java)
    }

    val apiServiceWorship: ApiServiceWeeklyWorship by lazy {
        retrofit.create(ApiServiceWeeklyWorship::class.java)
    }
}