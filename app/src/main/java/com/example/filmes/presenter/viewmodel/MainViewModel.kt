package com.example.filmes.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.filmes.data.repository.IFilmesRepository
import com.example.filmes.utils.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(val repository: IFilmesRepository) : ViewModel() {

    fun getFilmes() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getData()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    class ViewModelFactory(private val repository: IFilmesRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                return MainViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknow ViewModel class")
        }
    }
}
