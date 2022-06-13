package com.example.filmes.presenter.view

import android.R
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.filmes.data.api.RetrofitFilme
import com.example.filmes.data.model.FilmeResponse
import com.example.filmes.data.repository.FilmesRepository
import com.example.filmes.databinding.ActivityMainBinding
import com.example.filmes.presenter.adapter.FilmeItemAdapter
import com.example.filmes.presenter.viewmodel.MainViewModel
import com.example.filmes.utils.Status
import kotlinx.android.synthetic.main.activity_main.*

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
                        filmes_list_recyclerview.visibility = View.VISIBLE
                        progressBarMain.visibility = View.GONE
                        resource.data?.let { filmeResult -> filmeListAdapter.submitList(filmeResult.results) }
                    }
                    Status.ERROR -> {
                        filmes_list_recyclerview.visibility = View.VISIBLE
                        progressBarMain.visibility = View.GONE
                        alertError()
                    }
                    Status.LOADING -> {
                        progressBarMain.visibility = View.VISIBLE
                        filmes_list_recyclerview.visibility = View.GONE
                        Log.d("INFO:", "LOADING")
                    }
                }
            }
        }
    }

    fun alertError() {
        AlertDialog.Builder(this)
            .setIcon(R.drawable.ic_dialog_alert)
            .setTitle("Ocorreu um erro: ")
            .setMessage("Deseja tentar novamente?")
            .setPositiveButton(
                "Tentar novamente",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    setupViewModel()
                }
            )
            .setNegativeButton(
                "Sair",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    dialogInterface.dismiss()
                    Toast.makeText(this, "Tente novamente mais tarde.", Toast.LENGTH_LONG).show()
                }
            )
            .show()
    }
}
