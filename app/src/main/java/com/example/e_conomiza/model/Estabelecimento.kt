package com.example.e_conomiza.model

import com.google.gson.annotations.SerializedName

data class Estabelecimento (

    @SerializedName("cnpj")                    val cnpj : Int,
    @SerializedName("nomeEstabelecimento")     val nomeEstabelecimento: String,
    @SerializedName("logradouro")              val logradouro : String,
    @SerializedName("numero")                  val numero : Int,
    @SerializedName("cidade")                  val cidade : String,
    @SerializedName("cep")                    val cep : Int
)
