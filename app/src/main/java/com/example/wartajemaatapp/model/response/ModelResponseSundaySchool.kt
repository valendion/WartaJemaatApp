package com.example.wartajemaatapp.model.response

import com.google.gson.annotations.SerializedName

data class ModelResponseSundaySchool(
    @SerializedName("data")
    var data: ModelSundaySchool?,

    @SerializedName("status")
    var status: String? = "",
)
