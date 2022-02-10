package com.example.wartajemaatapp.model.response

import com.google.gson.annotations.SerializedName

data class ModelUangMasukKeluar(
    @SerializedName("id") var id: Int? = 0,

    @SerializedName("tanggal") var tanggal: String? = "",

    @SerializedName("keterangan") var keterangan: String? = "",

    @SerializedName("jumlah") var jumlah: String? = "",
)
