package com.example.nttdata_app_filmes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nttdata_app_filmes.databinding.ActivityFilmeDetailsBinding

class FilmeDetailsActivity: AppCompatActivity() {

    private val binding by lazy {
        ActivityFilmeDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

}