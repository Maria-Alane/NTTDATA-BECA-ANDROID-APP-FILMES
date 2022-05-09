package com.example.filmes.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiFilme {

    companion object {

        const val API_KEY = "?api_key=99000895bc6128ccb53c7b8ff66cc165"
        const val FILME_POPULAR = "movie/popular$API_KEY"
    }

    @GET(FILME_POPULAR)
    fun getData(): Call<FilmeResult>
}
