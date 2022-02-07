package com.example.wartajemaatapp.model.response

import com.google.gson.annotations.SerializedName

data class ModelResponseBirthdayInfo(
    @SerializedName("data")
    var data: MutableList<ModelResponseBirthdayData?>,

    @SerializedName("status")
    var status: String? = "",
)
