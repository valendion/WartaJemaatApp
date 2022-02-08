package com.example.wartajemaatapp.model.network

import com.example.wartajemaatapp.model.response.ModelResponseBirthdayInfo
import com.example.wartajemaatapp.model.response.ModelResponseReflection
import com.example.wartajemaatapp.model.response.ModelResponseShepherdOfGod
import com.example.wartajemaatapp.model.response.ModelResponseThanksGiving
import retrofit2.http.GET

interface ApiServiceMain {
    @GET("birthday_info") suspend fun getBirthday(): ModelResponseBirthdayInfo
    @GET("ibadah_syukur") suspend fun getThanksGiving(): ModelResponseThanksGiving
    @GET("gembala") suspend fun getShepherd(): ModelResponseShepherdOfGod
    @GET("renungan") suspend fun getReflection(): ModelResponseReflection
}