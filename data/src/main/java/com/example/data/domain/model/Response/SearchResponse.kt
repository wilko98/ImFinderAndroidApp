package com.example.data.domain.model.Response

import com.google.gson.annotations.SerializedName


data class SearchResponse(
    @SerializedName("results")
    val photoResults: List<PhotoResult>,
    val total: Int,
    val total_pages: Int
)