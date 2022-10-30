package com.example.rickandmortycharacters.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.rickandmortycharacters.R
import com.example.rickandmortycharacters.databinding.FragmentMainPageBinding
import com.example.rickandmortycharacters.model.CharactersModel
import com.example.rickandmortycharacters.network.RetrofitBuilder
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class MainPageFragment : Fragment() {

    private val binding by lazy {
        FragmentMainPageBinding.inflate(layoutInflater)
    }

    private val MyTagHere = "TAG"

    private val searchView by lazy {
        binding.toolBar.menu.findItem(R.id.search).actionView as androidx.appcompat.widget.SearchView
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        setUpItems()
        callAPI()
        setListeners()
        return binding.root
    }

    private fun callAPI() {
        val call = RetrofitBuilder.getRetrofitInstance().getCharacters(1,10)
        call.enqueue(object : Callback<List<CharactersModel>?> {
            
        })
    }

    private fun setUpItems() {
        searchView.queryHint = "Search for characters..."
    }

    private fun setListeners() {

    }


}