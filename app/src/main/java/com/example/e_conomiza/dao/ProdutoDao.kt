package com.example.e_conomiza.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.e_conomiza.model.Produto

@Dao
interface ProdutoDao {

    @Insert
    fun insert(produto: Produto)

    @Query("SELECT * fROM Produto")
    fun consultar(): List<Produto>

}