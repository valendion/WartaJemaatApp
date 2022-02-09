package com.example.wartajemaatapp.model.response

import com.google.gson.annotations.SerializedName

data class ModelSundaySchool(
    @SerializedName("id") var id: Int? = 0,

    @SerializedName("tanggal") var tanggal: String? = "",

    @SerializedName("team") var team: String? = "",

    @SerializedName("cerita_fa_kls_besar") var cerita_fa_kls_besar: String? = "",

    @SerializedName("cerita_fa_kls_kecil") var cerita_fa_kls_kecil: String? = "",

    @SerializedName("pujian") var pujian: String? = ""
)
