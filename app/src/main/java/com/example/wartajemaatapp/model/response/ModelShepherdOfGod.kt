package com.example.wartajemaatapp.model.response

import com.google.gson.annotations.SerializedName

data class ModelShepherdOfGod(
    @SerializedName("id")
    var id: Int? = 0,

    @SerializedName("nama")
    var nama: String? = "",

    @SerializedName("asal")
    var asal: String? = ""
)
