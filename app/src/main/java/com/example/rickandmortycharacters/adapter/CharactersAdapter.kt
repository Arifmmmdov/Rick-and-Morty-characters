package com.example.rickandmortycharacters.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortycharacters.R
import com.example.rickandmortycharacters.fragment.FragmentChanger
import com.example.rickandmortycharacters.model.CharactersModel

class CharactersAdapter(
    val instance: FragmentChanger,
    var charactersList: List<CharactersModel>,
    private val context: Context,
) : RecyclerView.Adapter<CharactersAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemGeneral = itemView.findViewById<ConstraintLayout>(R.id.item_general)
        private val imageView = itemView.findViewById<ImageView>(R.id.item_image)
        private val gender = itemView.findViewById<TextView>(R.id.gender)
        private val species = itemView.findViewById<TextView>(R.id.species)
        private val status = itemView.findViewById<TextView>(R.id.status)
        private val name = itemView.findViewById<TextView>(R.id.name)

        fun setItems(
            position: Int,
            charactersList: List<CharactersModel>,
            context: Context
        ) {
            Glide.with(context).load(charactersList[position].image).into(imageView)
            gender.text = charactersList[position].gender
            species.text = charactersList[position].species
            name.text = charactersList[position].name
            status.text = charactersList[position].status
        }

        fun setListeners(instance: FragmentChanger, position: Int) {
            itemGeneral.setOnClickListener{
                instance.changeTheFragment(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setItems(position, charactersList, context)
        holder.setListeners(instance,position)
    }

    override fun getItemCount(): Int = charactersList.size
}