package com.example.e_conomiza.model

import com.google.gson.annotations.SerializedName

data class Lista(

    @SerializedName("id") var idLista: Int,
    @SerializedName("nomeLista") val nomeLista : String
)
