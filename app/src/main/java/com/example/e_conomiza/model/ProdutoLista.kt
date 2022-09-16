package com.example.e_conomiza.model

import com.google.gson.annotations.SerializedName

data class ProdutoLista (
    @SerializedName("listaId")      val listaId:Int,
    @SerializedName("produtoId")    var produtoId: Int,
    @SerializedName("quantidade")   val quantidade:Int
)
