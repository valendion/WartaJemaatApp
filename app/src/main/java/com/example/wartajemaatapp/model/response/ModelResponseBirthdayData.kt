package com.example.wartajemaatapp.model.response

import com.google.gson.annotations.SerializedName

data class ModelResponseBirthdayData(
    @SerializedName("birthday_data")
    var birthdayData: MutableList<ModelBirthday?>,

    @SerializedName("start_of_week")
    var start_of_week: String? = "",

    @SerializedName("end_of_week")
    var end_of_week: String? = "",
)
