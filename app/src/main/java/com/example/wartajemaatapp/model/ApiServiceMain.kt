package com.example.wartajemaatapp.model

import retrofit2.http.GET

interface ApiServiceMain {
    @GET("birthday_info")
    suspend fun getBirthday(): ModelResponseBirthdayInfo
}