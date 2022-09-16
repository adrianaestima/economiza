package com.example.e_conomiza.Interface

import com.example.e_conomiza.model.ProdutoLista
import retrofit2.Call
import retrofit2.http.*

interface ProdutoListaApi {

    @POST("/produtoLista")
    fun gravarProdutoLista(@Body produtoLista: ProdutoLista) : Call<ProdutoLista>

    @GET("https://economiza.azurewebsites.net/produtoLista")
    suspend fun getProdutoLista(): List<ProdutoLista>

    @GET("https://economiza.azurewebsites.net/produtoLista/{id}")
    suspend fun getProdutoListaId()

    @PUT("https://economiza.azurewebsites.net/produtoLista/{id}")
    suspend fun updateProdutoLista()

    @DELETE("https://economiza.azurewebsites.net/produtoLista/{id}")
    suspend fun deleteProdutoLista()
}