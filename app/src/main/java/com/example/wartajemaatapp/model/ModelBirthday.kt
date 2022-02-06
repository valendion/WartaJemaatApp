package com.example.wartajemaatapp.model

import com.google.gson.annotations.SerializedName

data class ModelBirthday(
    @SerializedName("id")
    var id: Int? = 0,

    @SerializedName("nama")
    var nama: String? = "",

    @SerializedName("tanggal")
    var tanggal: String? = "",
)
