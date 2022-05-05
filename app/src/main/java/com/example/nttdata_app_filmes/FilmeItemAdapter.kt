package com.example.nttdata_app_filmes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nttdata_app_filmes.databinding.FilmeListItemBinding
import com.example.nttdata_app_filmes.model.Filme

class FilmeItemAdapter : ListAdapter<Filme, FilmeItemAdapter.FilmeViewHolder>(DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {
        val binding =
            FilmeListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class FilmeViewHolder(
        private val binding: FilmeListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(filme: Filme) {
            binding.textViewTitulo.text = filme.title
            binding.textViewLancamento.text = filme.release_date
        }

    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Filme>() {
            override fun areItemsTheSame(oldItem: Filme, newItem: Filme): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Filme, newItem: Filme): Boolean {
                return oldItem == newItem
            }

        }
    }
}

