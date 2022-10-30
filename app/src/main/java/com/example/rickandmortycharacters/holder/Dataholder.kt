package com.example.rickandmortycharacters.holder

import com.example.rickandmortycharacters.holder.DataHolder.charactersList
import com.example.rickandmortycharacters.model.CharactersModel
import com.example.rickandmortycharacters.model.ResultsEntity

interface DataHolderInterface {
    fun getCharactersList(): List<CharactersModel>
    fun addCharactersList(results: ResultsEntity)
    fun setSingleCharacterModel(position:Int)
    fun filterCharactersList(text:String):List<CharactersModel>
}

object DataHolder : DataHolderInterface {
    private var charactersList: HashSet<CharactersModel> = HashSet()
    lateinit var singleCharacterModel:CharactersModel

    override fun getCharactersList() = charactersList.toList()

    override fun addCharactersList(results: ResultsEntity) {
        charactersList.addAll(results.resultsEntity)
    }

    override fun setSingleCharacterModel(position: Int) {
        singleCharacterModel = charactersList.toList()[position]
    }

    override fun filterCharactersList(text: String): List<CharactersModel> {
        if(text == "")
            return charactersList.toList()
        val resultCharactersList = charactersList
//        val charactersListInstance:HashSet<CharactersModel> = HashSet()
////        charactersListInstance.filter {
////            !item.name.contains(text)&&!item.gender.contains(text)&&!item.species.contains(text)&&!item.status.contains(text)
////        }
//
//        for(item in charactersList){
//            if(!item.name.contains(text)&&!item.gender.contains(text)&&!item.species.contains(text)&&!item.status.contains(text)){
//                resultCharactersList.add(item)
//            }
//        }
//

        resultCharactersList.filter{
            it.name.contains(text)
        }



        return resultCharactersList.toList()
    }

}