package com.example.e_conomiza.Interface

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

// Função que devolve um retrofit todas as vezes que fizer uma Api
object RetrofitHelper{

    fun getInstance(): Retrofit{

        //Criando uma instância da classe Moshi
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        //Criando uma instância da classe retrofit
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://economiza.azurewebsites.net/")
            .build()
        return retrofit
    }
}
