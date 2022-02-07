package com.example.wartajemaatapp.model.network

import com.example.wartajemaatapp.model.response.ModelResponseBirthdayInfo
import com.example.wartajemaatapp.model.response.ModelResponseThanksGiving
import retrofit2.http.GET

interface ApiServiceMain {
    @GET("birthday_info") suspend fun getBirthday(): ModelResponseBirthdayInfo
    @GET("ibadah_syukur") suspend fun getThanksGiving(): ModelResponseThanksGiving

}