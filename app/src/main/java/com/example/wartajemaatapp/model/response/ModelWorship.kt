package com.example.wartajemaatapp.model.response

import com.google.gson.annotations.SerializedName

data class ModelWorship(
    @SerializedName("worship") var worship: String? = "",

    @SerializedName("leader") var leader: String? = "",

    @SerializedName("singer") var singer: String? = "",

    @SerializedName("musik") var musik: String? = "",

    @SerializedName("tambourine") var tambourine: String? = "",

    @SerializedName("mixer") var mixer: String? = "",

    @SerializedName("banner") var banner: String? = "",

    @SerializedName("lcd") var lcd: String? = "",

    @SerializedName("usher") var usher: String? = "",

    @SerializedName("pujian") var pujian: String? = "",

    @SerializedName("parkir") var parkir: String? = "",


)
