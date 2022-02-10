package com.example.wartajemaatapp.model.response

import com.google.gson.annotations.SerializedName

data class ModelResult(
    @SerializedName("id") var id: Int? = 0,

    @SerializedName("jumlah") var jumlah: String? = "",
)
