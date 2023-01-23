package com.example.googleauthapp.presentation.screen.AdicionarMercado

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.googleauthapp.domain.model.MercadoApi
import com.example.googleauthapp.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddMercadoViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {


    fun inserirNovoMercadoDB(mercado: MercadoApi){
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    val response = repository.addNovoMercado(mercado)
                } catch (e: Exception) {
                    print("$e")
                }
            }


    }

}