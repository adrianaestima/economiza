package com.example.e_conomiza.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Produto(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val nomeProduto : String,
    val marca : String
)