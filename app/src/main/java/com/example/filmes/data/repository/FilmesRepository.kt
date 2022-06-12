package com.example.filmes.data.repository

import com.example.filmes.data.api.ApiFilme
import com.example.filmes.data.api.FilmeResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FilmesRepository(
    private val apiFilme: ApiFilme
) : IFilmesRepository {
    override suspend fun getData(): FilmeResult {
        return withContext(Dispatchers.IO) {
            apiFilme.getData()
        }
    }
}
