package com.example.filmes.api

import com.example.filmes.model.Filme
import com.google.gson.annotations.SerializedName

data class FilmeResult(
    @SerializedName("pages")
    val pages: Int?,
    @SerializedName("results")
    val results: List<Filme>?,
    @SerializedName("total_results")
    val totalResults: Int?,
    @SerializedName("total_pages")
    val totalPages: Int?
)
