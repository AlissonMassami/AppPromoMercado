package com.example.googleauthapp.presentation.screen.Home

import android.content.ContentValues
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.googleauthapp.domain.model.*
import com.example.googleauthapp.domain.repository.Repository
import com.example.googleauthapp.util.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HommeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _signedInState: MutableState<Boolean> = mutableStateOf(false)
    val signedInState: State<Boolean> = _signedInState

    private val _messageBarState: MutableState<MessageBarState> = mutableStateOf(MessageBarState())
    val messageBarState: State<MessageBarState> = _messageBarState

    private val _apiResposta: MutableState<RequestState<ApiResposta>> =
        mutableStateOf(RequestState.Idle)
    val apiResposta: MutableState<RequestState<ApiResposta>> = _apiResposta


    private val _lista: MutableState<List<Mercado>> = mutableStateOf(emptyList())
    var lista1: State<List<Mercado>> = _lista

    init {
        getLista()
    }

    fun getLista(){
        viewModelScope.launch {
            _lista.value = repository.listaMercados().lista
            Log.d(ContentValues.TAG, "HomeScreenViewModel:${lista1} ")
        }
    }


    fun saveSignedInState(signedIn: Boolean) {

    }





}

