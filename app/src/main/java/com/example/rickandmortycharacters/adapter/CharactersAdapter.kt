package com.example.rickandmortycharacters.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortycharacters.databinding.RecyclerItemBinding
import com.example.rickandmortycharacters.model.CharactersModel

class CharactersAdapter(
    private val layoutInflater: LayoutInflater,
    private val charactersList: List<CharactersModel>,
    private val context: Context,
) : RecyclerView.Adapter<CharactersAdapter.MyViewHolder>() {

    private val binding by lazy {
        RecyclerItemBinding.inflate(layoutInflater)
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun setItems(position: Int) {
            Glide.with(context).load(charactersList[position].img).into(binding.itemImage)
            binding.gender.text = charactersList[position].gender
            binding.species.text = charactersList[position].species
            binding.name.text = charactersList[position].name
            binding.status.text = charactersList[position].status
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(binding.root)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setItems(position)
    }

    override fun getItemCount(): Int = charactersList.size
}