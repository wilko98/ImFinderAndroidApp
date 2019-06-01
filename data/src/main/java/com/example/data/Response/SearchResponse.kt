package com.example.data.Response


data class SearchResponse(
    val photoResults: List<PhotoResult>,
    val total: Int,
    val total_pages: Int
)