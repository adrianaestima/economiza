package com.example.e_conomiza.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.e_conomiza.dao.ProdutoDao
import com.example.e_conomiza.model.Produto

// Se atualizar a entidade produto deve mudar a versão
@Database(entities = [Produto::class], version = 1)
abstract class ProdutoDatabase : RoomDatabase() {

    abstract fun produtoDao(): ProdutoDao
}