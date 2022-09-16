package com.example.e_conomiza.Interface


import com.example.e_conomiza.model.Produto
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.GET


interface ProdutoApi {

    @POST("/produto")
    fun gravarProduto(@Body produto: String)

    @GET("/produto/{produto}")
    fun getProduto(@Path("produto") produto: String) : Call<List<Produto>>

    @GET("/produto/{id}")
    fun getProdutoId(@Path("id", encoded = false) key: Int,) : Call<Produto>

    @GET("/Produto/nome/{nome}")
    fun getProdutoNome(@Path("nome") nome: String) : Call<List<Produto>>


    @PUT("/produto/{id}")
    fun updateProduto(@Body produto: Produto,@Path("id", encoded = false) key: Int, ): Call<Produto>

    @DELETE("/produto/{id}")
    fun deleteProduto(@Path("id", encoded = false) key: Int,) : Call<Produto>
}


