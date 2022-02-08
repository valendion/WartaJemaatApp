package com.example.wartajemaatapp.model.network

import com.example.wartajemaatapp.model.response.*
import retrofit2.http.GET

interface ApiServiceSector {
    @GET("ibadah_sektor_sion") suspend fun getSectorSion(): ModelResponseSchedule
    @GET("ibadah_sektor_pisga") suspend fun getSectorPisga(): ModelResponseSchedule
    @GET("ibadah_sektor_torsina") suspend fun getSectorTorsina(): ModelResponseSchedule
    @GET("ibadah_sektor_hermon") suspend fun getSectorHermon(): ModelResponseSchedule
}