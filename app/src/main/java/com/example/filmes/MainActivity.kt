package com.example.filmes

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.filmes.api.FilmeResult
import com.example.filmes.api.RetrofitFilme
import com.example.filmes.databinding.ActivityMainBinding
import com.example.filmes.model.Filme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val apiFilme = RetrofitFilme.API_FILME

        val filmeListAdapter = FilmeItemAdapter()

        apiFilme.getData().enqueue(object : Callback<FilmeResult> {
            override fun onResponse(call: Call<FilmeResult>, response: Response<FilmeResult>) {
                if (response.isSuccessful) {
                    val filmeSelected = response.body()!!.results
                    filmeListAdapter.submitList(filmeSelected)
                }
            }

            override fun onFailure(call: Call<FilmeResult>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Erro ao carregar filmes!", Toast.LENGTH_LONG)
                    .show()
            }
        })

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
