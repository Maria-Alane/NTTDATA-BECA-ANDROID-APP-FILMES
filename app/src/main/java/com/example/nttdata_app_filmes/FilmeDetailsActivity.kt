package com.example.nttdata_app_filmes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nttdata_app_filmes.databinding.ActivityFilmeDetailsBinding
import com.example.nttdata_app_filmes.model.Filme
import com.example.nttdata_app_filmes.model.mockFilme

class FilmeDetailsActivity: AppCompatActivity() {

    private val binding by lazy {
        ActivityFilmeDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val filmeId = intent.getIntExtra("filmeId", 0)

        val filmeSelected = mockFilme().find { filme -> filme.id == filmeId }

        setData(filmeSelected)
    }

    private  fun setData(filmeSelected: Filme?) {
        filmeSelected?.let { filme ->
            binding.textViewTituloDetails.text = filme.title
            binding.textViewDescricao.text = filme.overview
            binding.textViewLancamentoDetails.text = filme.release_date
            binding.textViewVoteDetails.text = filme.vote_average.toString()
        }
    }

}