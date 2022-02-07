package com.example.wartajemaatapp.model.response

import com.google.gson.annotations.SerializedName

data class ModelResponseThanksGiving(
    @SerializedName("data")
    var data: MutableList<ModelThanksGiving>?,

    @SerializedName("status")
    var status: String? = "",
)
