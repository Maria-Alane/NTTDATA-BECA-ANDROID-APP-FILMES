package com.example.filmes.data.repository

import com.example.filmes.data.api.FilmeResult

interface IFilmesRepository {

    suspend fun getData(): FilmeResult
}
