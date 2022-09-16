package com.example.e_conomiza.Interface

import com.example.e_conomiza.model.Estoque
import retrofit2.http.*

interface EstoqueApi {

    @POST("https://economiza.azurewebsites.net/estoque")
    suspend fun gravarEstoque(@Body estoque: Estoque)

    @GET("https://economiza.azurewebsites.net/estoque")
    suspend fun getEstoque(): List<Estoque>

    @GET("https://economiza.azurewebsites.net/estoque/{id}")
    suspend fun getEstoqueId()

    @PUT("https://economiza.azurewebsites.net/estoque/{id}")
    suspend fun updateEstoque()

    @DELETE("https://economiza.azurewebsites.net/estoque/{id}")
    suspend fun deleteEstoque()
}