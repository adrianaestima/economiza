package com.example.e_conomiza.model

import com.google.gson.annotations.SerializedName

data class Estoque(

    @SerializedName("valor")        val valor: Double,
    @SerializedName("quantidade")   val quantidade: Int
)

