package com.example.googleauthapp.data.remote

import com.example.googleauthapp.domain.model.*
import retrofit2.http.*

interface KtorApi {

    @POST("/token_verification")
    suspend fun verifyTokenOnBackend(
        @Body request: ApiRequest
    ): ApiResponse

    @GET("/get_user")
    suspend fun getUserInfo(): ApiResponse

    @PUT("/update_user")
    suspend fun updateUser(
        @Body userUpdate: UserUpdate
    ): ApiResponse

    @DELETE("/delete_user")
    suspend fun deleteUser(): ApiResponse

    @GET("/sign_out")
    suspend fun clearSession(): ApiResponse

    @POST("/consulta_dia")
    suspend fun consultaDiaPromo(
        @Body requestMercado: ApiRequestMercado
    ): ApiResposta

    @GET("/lista_mercados")
    suspend fun listaMercados(): ApiRespostaLista

    @POST("/novo_mercado")
    suspend fun addNovoMercado(
        @Body mercado: MercadoApi
    ): ApiResposta
}