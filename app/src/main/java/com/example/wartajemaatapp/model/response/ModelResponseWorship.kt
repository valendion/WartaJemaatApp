package com.example.wartajemaatapp.model.response

import com.google.gson.annotations.SerializedName

data class ModelResponseWorship(
    @SerializedName("data")
    var data: MutableList<ModelWorship?>,

    @SerializedName("status")
    var status: String? = "",
)
