package com.example.wartajemaatapp.model

import com.google.gson.annotations.SerializedName

data class ModelResponseBirthdayInfo(
    @SerializedName("data")
    var data: MutableList<ModelBirthday?>,

    @SerializedName("status")
    var status: String? = "",
)
