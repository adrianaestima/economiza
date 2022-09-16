package com.example.e_conomiza.Interface

import com.example.e_conomiza.model.Estabelecimento
import retrofit2.http.*

interface EstabelecimentoApi {

    @POST("https://economiza.azurewebsites.net/estabelecimento")
    suspend fun gravarEstabelecimento(@Body estabelecimento: Estabelecimento)

    @GET("https://economiza.azurewebsites.net/estabelecimento")
    suspend fun getEstabelecimento(): List<Estabelecimento>

    @GET("https://economiza.azurewebsites.net/estabelecimento/{id}")
    suspend fun getEstabelecimentoId()


    @PUT("https://economiza.azurewebsites.net/estabelecimento/{id}")
    suspend fun updateEstabelecimento()

    @DELETE("https://economiza.azurewebsites.net/estabelecimento/{id}")
    suspend fun deleteEstabelecimento()
}