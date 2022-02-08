package com.example.wartajemaatapp.model.response

import com.google.gson.annotations.SerializedName

data class ModelThanksGiving(
    @SerializedName("id") var id: Int? = 0,

    @SerializedName("keterangan") var keterangan: String? = "",

    @SerializedName("tanggal") var tanggal: String? = "",

    @SerializedName("waktu") var waktu: String? = "",

    @SerializedName("alamat") var alamat: String? = ""
)
