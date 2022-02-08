package com.example.wartajemaatapp.model.response

import com.google.gson.annotations.SerializedName

data class ModelResponseSchedule(
    @SerializedName("data")
    var data: ModelSector?,

    @SerializedName("status")
    var status: String? = "",
)
