package com.example.rickandmortycharacters.fragment

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.SearchView
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortycharacters.R
import com.example.rickandmortycharacters.adapter.CharactersAdapter
import com.example.rickandmortycharacters.databinding.FragmentMainPageBinding
import com.example.rickandmortycharacters.holder.DataHolder
import com.example.rickandmortycharacters.model.CharactersModel
import com.example.rickandmortycharacters.model.ResultsEntity
import com.example.rickandmortycharacters.network.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface FragmentChanger {
    fun changeTheFragment(position: Int)
}


class MainPageFragment : Fragment(), FragmentChanger {


    private lateinit var adapter: CharactersAdapter

    private var mPage = 1

    private var isItSetAlready = false

    private val binding by lazy {
        FragmentMainPageBinding.inflate(layoutInflater)
    }

    private val TAG = "MyTagHere "

    private val searchView by lazy {
        binding.toolBar.menu.findItem(R.id.search).actionView as androidx.appcompat.widget.SearchView
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        setUpItems()
        callAPI(10)
        setListeners()
        return binding.root
    }

    private fun callAPI(limit: Int) {
        val call = RetrofitBuilder.getRetrofitInstance().getCharacters(mPage, limit)
        call.enqueue(object : Callback<ResultsEntity> {
            override fun onResponse(
                call: Call<ResultsEntity>,
                response: Response<ResultsEntity>
            ) {
                if (response.isSuccessful) {
                    setAllCharacters(response.body()!!)
                    if (isItSetAlready) notifyRecyclerViewAdapter() else setItemsToRecycler(
                        DataHolder.getCharactersList()
                    )
                    mPage++
                    isItSetAlready = true
                } else
                    Log.d(TAG, "onResponse: ${response.message()}")
            }

            override fun onFailure(call: Call<ResultsEntity>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }

        })
    }

    private fun setItemsToRecycler(charactersList: List<CharactersModel>) {
        adapter = CharactersAdapter(this, charactersList, requireContext()).also {
            binding.recyclerView.adapter = it
        }

        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    private fun notifyRecyclerViewAdapter() {
        adapter.charactersList = DataHolder.getCharactersList()
        adapter.notifyItemInserted(DataHolder.getCharactersList().size - 5)
    }

    private fun setAllCharacters(results: ResultsEntity) {
        DataHolder.addCharactersList(results)
    }

    private fun setUpItems() {
        searchView.queryHint = "Search for characters..."
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setListeners() {
        binding.nestedScrollView.setOnScrollChangeListener { v: NestedScrollView, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight)
                callAPI(5)
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                setItemsToRecycler(DataHolder.filterCharactersList(newText!!))
                return false
            }

        })

    }

    override fun changeTheFragment(position: Int) {
        DataHolder.setSingleCharacterModel(position)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_mainPageFragment_to_detailsFragment)
    }


//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        MenuInflater(requireContext()).inflate(R.menu.my_menu,menu)
//        menuItem = menu.findItem(R.id.search)
//
//    }

}