package com.example.googleauthapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Dia(
    val domingo: String?,
    val segunda: String?,
    val terca: String?,
    val quarta: String?,
    val quinta: String?,
    val sexta: String?,
    val sabado: String?,

    )
