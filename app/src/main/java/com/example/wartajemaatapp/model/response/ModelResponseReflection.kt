package com.example.wartajemaatapp.model.response

import com.google.gson.annotations.SerializedName

data class ModelResponseReflection(
    @SerializedName("data")
    var data: ModelReflection?,

    @SerializedName("status")
    var status: String? = "",
)
