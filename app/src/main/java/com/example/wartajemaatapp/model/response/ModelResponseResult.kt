package com.example.wartajemaatapp.model.response

import com.google.gson.annotations.SerializedName

data class ModelResponseResult (
    @SerializedName("data")
    var data: MutableList<ModelResult?>,

    @SerializedName("status")
    var status: String? = ""
)