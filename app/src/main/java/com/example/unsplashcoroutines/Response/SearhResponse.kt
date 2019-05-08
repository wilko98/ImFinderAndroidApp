package com.example.unsplashcoroutines.Response

data class SearhResponse(

    val results: List<Result>,
    val total: Int,
    val total_pages: Int
)