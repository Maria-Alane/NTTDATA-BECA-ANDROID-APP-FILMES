package com.example.filmes.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.filmes.data.model.FilmeResponse

class FilmeDetailsViewModel(
    filme: FilmeResponse?
) : ViewModel() {

    private val _filmesDetailsLiveData = MutableLiveData<FilmeResponse>(filme)
    val filmesDetailsLiveData: LiveData<FilmeResponse> = _filmesDetailsLiveData

    class ViewModelFactory(val filme: FilmeResponse?) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(FilmeDetailsViewModel::class.java)) {
                return FilmeDetailsViewModel(filme) as T
            }
            throw IllegalArgumentException("Unknow ViewModel class")
        }
    }
}
