package com.example.nttdata_app_filmes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nttdata_app_filmes.databinding.ActivityMainBinding
import com.example.nttdata_app_filmes.model.mockFilme

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val filmeListAdapter = FilmeItemAdapter()

        binding.filmesListRecyclerview.adapter = filmeListAdapter

        filmeListAdapter.submitList(mockFilme())

    }
}