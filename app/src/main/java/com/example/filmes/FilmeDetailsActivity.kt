package com.example.filmes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.filmes.databinding.ActivityFilmeDetailsBinding
import com.example.filmes.model.Filme

class FilmeDetailsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFilmeDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val filme = intent.getParcelableExtra<Filme>("filme")
        setFilme(filme)
    }

    private fun setFilme(filmeSelected: Filme?) {
        filmeSelected?.let { filme ->
            binding.textViewTituloDetails.text = filme.title
            binding.textViewDescricao.text = filme.overview
        }
    }
}
