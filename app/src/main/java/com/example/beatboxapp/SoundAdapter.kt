package com.example.beatboxapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.beatboxapp.databinding.ListItemSoundBinding

class SoundAdapter(private val sounds: List<Sound>) :
    RecyclerView.Adapter<SoundAdapter.SoundHolder>() {

    class SoundHolder(private val binding: ListItemSoundBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.viewModel = SoundViewModel()
        }

        fun bind(sound: Sound) {
            binding.apply {
                viewModel?.sound = sound
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundHolder {
        val binding = DataBindingUtil.inflate<ListItemSoundBinding>(
            LayoutInflater.from(parent.context),
            R.layout.list_item_sound,
            parent,
            false
        )
        return SoundHolder(binding)
    }

    override fun onBindViewHolder(holder: SoundHolder, position: Int) {
        val sound = sounds[position]
        holder.bind(sound)
    }

    override fun getItemCount(): Int {
        return sounds.size
    }
}