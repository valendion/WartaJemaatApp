package com.example.wartajemaatapp.model.response

import com.google.gson.annotations.SerializedName

data class ModelResponseUangMasukKeluar(
    @SerializedName("data")
    var data: MutableList<ModelUangMasukKeluar?>,

    @SerializedName("status")
    var status: String? = "",
)
