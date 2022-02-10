package com.example.wartajemaatapp.model.network

import com.example.wartajemaatapp.model.response.*
import retrofit2.http.GET

interface ApiServiceFinancialStatements {
    @GET("lk_pembangunan_masuk") suspend fun getPembangunanMasuk(): ModelResponseUangMasukKeluar
    @GET("lk_pembangunan_keluar") suspend fun getPembangunanKeluar(): ModelResponseUangMasukKeluar
    @GET("lk_pembangunan_saldo") suspend fun getPembangunanSaldo(): ModelResponseShepherdOfGod

    @GET("lk_kas_jemaat_masuk") suspend fun getJemaatMasuk(): ModelResponseUangMasukKeluar
    @GET("lk_kas_jemaat_keluar") suspend fun getJemaatKeluar(): ModelResponseUangMasukKeluar
    @GET("lk_kas_jemaat_saldo") suspend fun getJemaatSaldo(): ModelResponseResult

    @GET("lk_sarana_masuk") suspend fun getSaranaMasuk(): ModelResponseUangMasukKeluar
    @GET("lk_sarana_keluar") suspend fun getSaranaKeluar(): ModelResponseUangMasukKeluar
    @GET("lk_sarana_saldo") suspend fun getSaranaSaldo(): ModelResponseShepherdOfGod
}