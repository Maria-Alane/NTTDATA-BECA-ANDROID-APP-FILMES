package com.example.filmes.presenter.viewmodel

import androidx.lifecycle.*
import com.example.filmes.data.api.FilmeResult
import com.example.filmes.data.repository.IFilmesRepository
import kotlinx.coroutines.launch

class MainViewModel(val repository: IFilmesRepository) : ViewModel() {

    private val _filmesLiveData = MutableLiveData<FilmeResult>()
    val filmesLiveData: LiveData<FilmeResult> = _filmesLiveData

    fun getFilmes() {
        viewModelScope.launch {
            val filmeList = repository.getData()
            _filmesLiveData.value = filmeList
        }
    }

//    fun getFilmes() = liveData(Dispatchers.IO) {
//        emit(Resource.loading(data = null))
//        try {
//            emit(Resource.success(data = repository.getData()))
//        } catch (exception: Exception) {
//            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
//        }
//    }

//
//    fun getFilmes() {
//        val apiFilme = RetrofitFilme.API_FILME
//        apiFilme.getData().enqueue(object : Callback<FilmeResult> {
//            override fun onResponse(call: Call<FilmeResult>, response: Response<FilmeResult>) {
//                if (response.isSuccessful) {
//                    _filmesLiveData.value = response.body()
//                }
//            }
//
//            override fun onFailure(call: Call<FilmeResult>, t: Throwable) {
//                Toast.makeText(context, "Erro ao carregar filmes!", Toast.LENGTH_LONG)
//                    .show()
//            }
//        })
//    }

    class ViewModelFactory(private val repository: IFilmesRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                return MainViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknow ViewModel class")
        }
    }
}
