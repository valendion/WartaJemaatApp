package com.example.wartajemaatapp.model.response

import com.google.gson.annotations.SerializedName

data class ModelResponseShepherdOfGod(
    @SerializedName("data")
    var data: ModelShepherdOfGod?,

    @SerializedName("status")
    var status: String? = "",
)
