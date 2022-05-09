package com.example.filmes.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.filmes.FilmeItemAdapter
import com.example.filmes.MainViewModel
import com.example.filmes.databinding.ActivityMainBinding
import com.example.filmes.model.Filme

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel =
        MainViewModel.ViewModelFactory(this@MainActivity)
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

    private fun goToDetails(filme: Filme) {
        val intent = Intent(this, FilmeDetailsActivity::class.java)
        intent.putExtra("filme", filme)
        startActivity(intent)
    }
}
