package com.example.esportapi.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.esportapi.network.Esport
import com.example.esportapi.network.GameApi
import kotlinx.coroutines.launch

enum class GameApiStatus { LOADING, ERROR, DONE }

class GameViewModel : ViewModel(){
    private val _status = MutableLiveData<GameApiStatus>()
    val status: LiveData<GameApiStatus> = _status

    private val _games = MutableLiveData<MutableList<Esport>>()
    val games: MutableLiveData<MutableList<Esport>> = _games

    private val _game = MutableLiveData<Esport>()
    val esport: LiveData<Esport> = _game

    fun getGameList() {
        viewModelScope.launch {
        _status.value = GameApiStatus.LOADING
            try {
                _games.value = GameApi.retrofitServiceApi.getGames()
                _status.value = GameApiStatus.DONE
            } catch (e: Exception) {
                _games.value = mutableListOf()
                _status.value = GameApiStatus.ERROR
            }
        }
    }

    fun onGameClicked(esport: Esport) {
        _game.value = esport
    }

}