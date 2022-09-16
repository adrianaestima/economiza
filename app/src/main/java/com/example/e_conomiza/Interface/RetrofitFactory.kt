package com.example.e_conomiza.Interface

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Classe  para instanciar o retrofit
class RetrofitFactory {

    val URL: String = "https://economiza.azurewebsites.net"

    // Criando o objeto RetrofitFactory
    val retrofitFactory = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Função que cria uma instância para fazer a requisição no Retrofit
    fun produtoApi() : ProdutoApi {
        return retrofitFactory.create(ProdutoApi::class.java)
    }

    fun listaApi(): ListaApi {
        return retrofitFactory.create(ListaApi::class.java)

    }

    fun produtoListaApi(): ProdutoListaApi{
        return retrofitFactory.create((ProdutoListaApi::class.java))

    }
}