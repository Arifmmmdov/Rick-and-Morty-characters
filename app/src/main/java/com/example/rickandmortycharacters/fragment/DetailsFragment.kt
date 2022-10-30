package com.example.rickandmortycharacters.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rickandmortycharacters.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {


    private val binding by lazy{
        FragmentDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        setListeners()
        return binding.root
    }

    private fun setListeners() {

    }

}