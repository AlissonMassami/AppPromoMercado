package com.example.googleauthapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class MercadoApi(
    val name: String,
    val dia: Dia
    )
