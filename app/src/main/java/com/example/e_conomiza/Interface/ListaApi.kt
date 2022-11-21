package com.example.e_conomiza.Interface

import com.example.e_conomiza.model.Lista
import retrofit2.http.*
import retrofit2.Call

interface ListaApi {

    @POST("/Lista")
    fun gravarLista(@Body nomeLista: String) : Call<Lista>

    @GET("/Lista/{lista}")
    fun getLista(): List<Lista>

    @GET("/Lista/{id}")
    fun getListaId(toInt: Int)

    @PUT("/Lista/{id}")
    fun updateLista()

    @DELETE("/Lista/{id}")
    fun deleteLista()

}