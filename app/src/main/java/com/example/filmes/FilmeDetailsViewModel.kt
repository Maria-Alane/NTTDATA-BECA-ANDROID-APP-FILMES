package com.example.filmes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.filmes.model.Filme

class FilmeDetailsViewModel(
    filme: Filme?
) : ViewModel() {

    val filmesDetailsLiveData: MutableLiveData<Filme> = MutableLiveData(filme)

    class ViewModelFactory(val filme: Filme?) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(FilmeDetailsViewModel::class.java)) {
                return FilmeDetailsViewModel(filme) as T
            }
            throw IllegalArgumentException("Unknow ViewModel class")
        }
    }
}
