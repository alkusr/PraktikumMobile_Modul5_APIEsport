package com.example.esportapi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.esportapi.databinding.ListViewItemBinding
import com.example.esportapi.network.Esport

class GameListAdapter(val clickListener: GameListener) :
    ListAdapter<Esport, GameListAdapter.GameViewHolder>(DiffCallback) {

    class GameViewHolder(
        var binding: ListViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: GameListener, esport: Esport){
            binding.game = esport
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Esport>(){

        override fun areItemsTheSame(oldItem: Esport, newItem: Esport): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Esport, newItem: Esport): Boolean {
            return oldItem.thumb == newItem.thumb && oldItem.desc == newItem.desc
                    && oldItem.author == newItem.author && oldItem.tag == newItem.tag
                    && oldItem.time == newItem.time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return GameViewHolder(
            ListViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int){
        val game = getItem(position)
        holder.bind(clickListener, game)
    }

}

class GameListener(val clickListener: (esport: Esport) -> Unit) {
    fun onClick(esport: Esport) = clickListener(esport)
}