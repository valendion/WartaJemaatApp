package com.example.wartajemaatapp.model.network

import com.example.wartajemaatapp.model.response.*
import retrofit2.http.GET

interface ApiServiceMain {
    @GET("birthday_info") suspend fun getBirthday(): ModelResponseBirthdayInfo
    @GET("ibadah_syukur") suspend fun getThanksGiving(): ModelResponseThanksGiving
    @GET("gembala") suspend fun getShepherd(): ModelResponseShepherdOfGod
    @GET("renungan") suspend fun getReflection(): ModelResponseReflection
    @GET("ibadah_sekolah_minggu") suspend fun getSundaySchool(): ModelResponseSundaySchool
}