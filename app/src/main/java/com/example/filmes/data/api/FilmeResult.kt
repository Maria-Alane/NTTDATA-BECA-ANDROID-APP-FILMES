package com.example.filmes.data.api

import com.example.filmes.data.model.FilmeResponse
import com.google.gson.annotations.SerializedName

data class FilmeResult(
    @SerializedName("pages")
    val pages: Int?,
    @SerializedName("results")
    val results: List<FilmeResponse>?,
    @SerializedName("total_results")
    val totalResults: Int?,
    @SerializedName("total_pages")
    val totalPages: Int?
)
