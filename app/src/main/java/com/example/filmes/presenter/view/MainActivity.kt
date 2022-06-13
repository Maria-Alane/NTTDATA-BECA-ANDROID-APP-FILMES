package com.example.filmes.presenter.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.filmes.data.api.RetrofitFilme
import com.example.filmes.data.model.FilmeResponse
import com.example.filmes.data.repository.FilmesRepository
import com.example.filmes.databinding.ActivityMainBinding
import com.example.filmes.presenter.adapter.FilmeItemAdapter
import com.example.filmes.presenter.viewmodel.MainViewModel
import com.example.filmes.utils.Status

class MainActivity : AppCompatActivity() {

    private lateinit var filmeListAdapter: FilmeItemAdapter

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel =
        MainViewModel.ViewModelFactory(FilmesRepository(apiFilme = RetrofitFilme.API_FILME))
            .create(MainViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupViewModel()

        filmeListAdapter = FilmeItemAdapter()

        binding.filmesListRecyclerview.adapter = filmeListAdapter

        filmeListAdapter.onClickListener = { filme ->
            goToDetails(filme)
        }
    }

    private fun goToDetails(filme: FilmeResponse) {
        val intent = Intent(this, FilmeDetailsActivity::class.java)
        intent.putExtra("filme", filme)
        startActivity(intent)
    }

    private fun setupViewModel() {
        viewModel.getFilmes().observe(this) {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let { filmeResult -> filmeListAdapter.submitList(filmeResult.results) }
                    }
                    Status.ERROR -> {
                        Log.d("INFO:", "OCORREU UM ERRO")
                    }
                    Status.LOADING -> {
                        Log.d("INFO:", "LOADING")
                    }
                }
            }
        }
    }
}
