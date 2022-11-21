package com.example.e_conomiza.activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.e_conomiza.R

class ProdutosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produtos)

        // Escondendo a barra de Ação
        supportActionBar!!.hide()

        //Declarando as variáveis
        val txtNomeLista: TextView = findViewById(R.id.txt_nome_lista_nova)


        //Recuperando o nome da lista criada
        val nomeListaSharedPreference: SharedPreferences =
            this.getSharedPreferences("lista", MODE_PRIVATE)
        val nomeLista: String? = nomeListaSharedPreference.getString("nome_lista", "")

        //Imprimindo o nome da lista
        txtNomeLista.text = nomeLista


        val btnSalvarLista: Button = findViewById(R.id.btn_salvar_lista)

        btnSalvarLista.setOnClickListener{
            val x = Intent(this, ListaActivity::class.java)
            startActivity(x)
        }
    }
}