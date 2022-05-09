package com.example.filmes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.filmes.databinding.FilmeListItemBinding
import com.example.filmes.model.Filme

class FilmeItemAdapter : ListAdapter<Filme, FilmeItemAdapter.FilmeViewHolder>(DIFF_CALLBACK) {

    var onClickListener: ((filme: Filme) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {
        val binding =
            FilmeListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmeViewHolder(binding, onClickListener)
    }

    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class FilmeViewHolder(
        private val binding: FilmeListItemBinding,
        private val onClickListener: ((filme: Filme) -> Unit)?
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(filme: Filme) {
            binding.textViewTitulo.text = filme.title
            binding.textViewLancamento.text = filme.releaseDate
            binding.textViewVote.text = filme.voteAverage.toString()

            binding.root.setOnClickListener {
                onClickListener?.invoke(filme)
            }
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
