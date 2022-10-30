package com.example.rickandmortycharacters.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.rickandmortycharacters.databinding.FragmentDetailsBinding
import com.example.rickandmortycharacters.holder.DataHolder

class DetailsFragment : Fragment() {

    private val characterModel by lazy {
        DataHolder.singleCharacterModel
    }

    private val binding by lazy {
        FragmentDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        setViews()
        setListeners()
        return binding.root
    }

    private fun setViews() {
        Glide.with(requireContext()).load(characterModel.image).into(binding.detailedImage)
        binding.detailedGenderInfo.text = characterModel.gender
        binding.detailedName.text = characterModel.name
        binding.detailedSpeciesInfo.text = characterModel.species
        binding.detailedTypeInfo.text = characterModel.type
        binding.detailedOriginInfo.text = characterModel.origin.name
    }

    private fun setListeners() {

    }

}