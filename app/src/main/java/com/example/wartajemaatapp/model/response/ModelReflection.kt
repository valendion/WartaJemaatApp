package com.example.wartajemaatapp.model.response

import com.google.gson.annotations.SerializedName

data class ModelReflection(
    @SerializedName("id") var id: Int? = 0,

    @SerializedName("tanggal") var tanggal: String? = "",

    @SerializedName("judul") var judul: String? = "",

    @SerializedName("ayat") var ayat: String? = "",

    @SerializedName("pengarang") var pengarang: String? = "",

    @SerializedName("deskripsi_1") var deskripsi_1: String? = "",

    @SerializedName("deskripsi_2") var deskripsi_2: String? = "",
)
