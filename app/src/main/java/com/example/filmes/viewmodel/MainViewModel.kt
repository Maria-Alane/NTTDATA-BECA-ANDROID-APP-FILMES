package com.example.filmes.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.filmes.api.FilmeResult
import com.example.filmes.api.RetrofitFilme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.IllegalArgumentException

class MainViewModel(private val context: Context) : ViewModel() {

    val filmesLiveData: MutableLiveData<FilmeResult> = MutableLiveData()

    fun getFilmes() {
        val apiFilme = RetrofitFilme.API_FILME
        apiFilme.getData().enqueue(object : Callback<FilmeResult> {
            override fun onResponse(call: Call<FilmeResult>, response: Response<FilmeResult>) {
                if (response.isSuccessful) {
                    filmesLiveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<FilmeResult>, t: Throwable) {
                Toast.makeText(context, "Erro ao carregar filmes!", Toast.LENGTH_LONG)
                    .show()
            }
        })
    }

    class ViewModelFactory(val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                return MainViewModel(context) as T
            }
            throw IllegalArgumentException("Unknow ViewModel class")
        }
    }
}
