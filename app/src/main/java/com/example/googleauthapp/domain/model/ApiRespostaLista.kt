package com.example.googleauthapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiRespostaLista(
    val lista: List<Mercado>
)
