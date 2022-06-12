package com.example.filmes.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmes.data.model.FilmeResponse
import com.example.filmes.databinding.FilmeListItemBinding

class FilmeItemAdapter : ListAdapter<FilmeResponse, FilmeItemAdapter.FilmeViewHolder>(DIFF_CALLBACK) {

    var onClickListener: ((filme: FilmeResponse) -> Unit)? = null

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
        private val onClickListener: ((filme: FilmeResponse) -> Unit)?
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(filme: FilmeResponse) {
            binding.textViewTitulo.text = filme.title
            binding.textViewVote.text = filme.voteAverage.toString()

            Glide
                .with(binding.root.context)
                .load("https://image.tmdb.org/t/p/original" + filme.backdropPath)
                .centerCrop()
                .into(binding.imagemViewFilme)

            binding.root.setOnClickListener {
                onClickListener?.invoke(filme)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FilmeResponse>() {
            override fun areItemsTheSame(oldItem: FilmeResponse, newItem: FilmeResponse): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: FilmeResponse, newItem: FilmeResponse): Boolean {
                return oldItem == newItem
            }
        }
    }
}
