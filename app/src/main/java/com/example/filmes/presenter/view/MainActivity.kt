package com.example.filmes.presenter.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.filmes.data.api.RetrofitFilme
import com.example.filmes.data.model.FilmeResponse
import com.example.filmes.data.repository.FilmesRepository
import com.example.filmes.databinding.ActivityMainBinding
import com.example.filmes.presenter.adapter.FilmeItemAdapter
import com.example.filmes.presenter.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel =
        MainViewModel.ViewModelFactory(FilmesRepository(apiFilme = RetrofitFilme.API_FILME))
            .create(MainViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val filmeListAdapter = FilmeItemAdapter()

        viewModel.getFilmes()

        viewModel.filmesLiveData.observe(this) { filmeResult ->
            filmeListAdapter.submitList(filmeResult.results)
        }

        filmeListAdapter.onClickListener = { filme ->
            goToDetails(filme)
        }

        binding.filmesListRecyclerview.adapter = filmeListAdapter
    }

    private fun goToDetails(filme: FilmeResponse) {
        val intent = Intent(this, FilmeDetailsActivity::class.java)
        intent.putExtra("filme", filme)
        startActivity(intent)
    }
}
