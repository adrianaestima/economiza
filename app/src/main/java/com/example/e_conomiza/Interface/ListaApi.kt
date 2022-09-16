package com.example.e_conomiza.Interface

import com.example.e_conomiza.model.Lista
import retrofit2.http.*
import retrofit2.Call

interface ListaApi {

    @POST("/lista")
    fun gravarLista(@Body lista: String) : Call<Lista>

    @GET("/lista/{lista}")
    fun getLista(): List<Lista>

    @GET("/lista/{id}")
    fun getListaId(toInt: Int)

    @PUT("/lista/{id}")
    fun updateLista()

    @DELETE("/lista/{id}")
    fun deleteLista()

}