package ru.nikiz.domain

import com.google.gson.annotations.SerializedName

class BaseResponse<T>(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("previous")
    val previous: String? = null,
    @SerializedName("results")
    val results: List<T>
)