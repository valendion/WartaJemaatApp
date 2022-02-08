package com.example.wartajemaatapp.model.network

import com.example.wartajemaatapp.model.response.ModelResponseBirthdayInfo
import com.example.wartajemaatapp.model.response.ModelResponseShepherdOfGod
import com.example.wartajemaatapp.model.response.ModelResponseThanksGiving
import com.example.wartajemaatapp.model.response.ModelResponseWorship
import retrofit2.http.GET

interface ApiServiceWeeklyWorship {
    @GET("ibadah_minggu_pagi") suspend fun getSundayMorning(): ModelResponseWorship
    @GET("ibadah_minggu_malam") suspend fun getSundayNight(): ModelResponseWorship
    @GET("ibadah_sabtu") suspend fun getSaturday(): ModelResponseWorship
}