package com.example.googleauthapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Mercado(
    val name: String,
    val dia: Map<String,String>
    )
