package com.example.wartajemaatapp.model.network

import com.example.wartajemaatapp.model.response.ModelResponseBirthdayInfo
import com.example.wartajemaatapp.model.response.ModelResponseShepherdOfGod
import com.example.wartajemaatapp.model.response.ModelResponseThanksGiving
import retrofit2.http.GET

interface ApiServiceFinancialStatements {
    @GET("lk_pembangunan_masuk") suspend fun getPembangunanMasuk(): ModelResponseBirthdayInfo
    @GET("lk_pembangunan_keluar") suspend fun getPembangunanKeluar(): ModelResponseThanksGiving
    @GET("lk_pembangunan_saldo") suspend fun getPembangunanSaldo(): ModelResponseShepherdOfGod

    @GET("lk_kas_jemaat_masuk") suspend fun getJemaatMasuk(): ModelResponseBirthdayInfo
    @GET("lk_kas_jemaat_keluar") suspend fun getJemaatKeluar(): ModelResponseThanksGiving
    @GET("lk_kas_jemaat_saldo") suspend fun getJemaatSaldo(): ModelResponseShepherdOfGod

    @GET("lk_sarana_masuk") suspend fun getSaranaMasuk(): ModelResponseBirthdayInfo
    @GET("lk_sarana_keluar") suspend fun getSaranaKeluar(): ModelResponseThanksGiving
    @GET("lk_sarana_saldo") suspend fun getSaranaSaldo(): ModelResponseShepherdOfGod
}