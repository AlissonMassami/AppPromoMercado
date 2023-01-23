package com.example.googleauthapp.domain.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class ApiResposta(
    val success: Boolean,
    val mercado : MercadoApi? = null,
    val message: String? = null,
    @Transient
    val error: Exception? = null
)
