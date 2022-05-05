package com.example.nttdata_app_filmes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nttdata_app_filmes.databinding.FilmeListItemBinding
import com.example.nttdata_app_filmes.model.Filme

class FilmeItemAdapter : ListAdapter<Filme, FilmeItemAdapter.FilmeViewHolder>(DIFF_CALLBACK) {

    var onClickListener: ((filmeId: Int) -> Unit)? = null

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
        private val onClickListener: ((filmeId: Int) -> Unit)?
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(filme: Filme) {
            binding.textViewTitulo.text = filme.title
            binding.textViewLancamento.text = filme.release_date

            binding.root.setOnClickListener {
                onClickListener?.invoke(filme.id)
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

