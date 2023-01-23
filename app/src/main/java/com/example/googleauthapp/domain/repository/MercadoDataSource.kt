package com.example.googleauthapp.domain.repository

import kotlinx.coroutines.flow.Flow

interface MercadoDataSource {
    suspend fun saveSignedInState(signedIn: Boolean)
    fun readSignedInState(): Flow<Boolean>
}