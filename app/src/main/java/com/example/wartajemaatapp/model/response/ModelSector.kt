package com.example.wartajemaatapp.model.response

import com.google.gson.annotations.SerializedName

data class ModelSector(
    @SerializedName("id") var id: Int? = 0,

    @SerializedName("tanggal") var tanggal: String? = "",

    @SerializedName("nama_keluarga") var nama_keluarga: String? = "",

    @SerializedName("alamat") var alamat: String? = "",

    @SerializedName("waktu") var waktu: String? = ""
)
