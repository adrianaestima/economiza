package com.example.e_conomiza.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.e_conomiza.R

class ListaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        // Declarando as variáveis
        val txtNomeLista: TextView = findViewById(R.id.txt_nome_lista_nova)
        val btn_finaliza: Button = findViewById(R.id.btn_finalizar)

        // Escondendo a barra de Ação
        supportActionBar!!.hide()

        //Recuperando o nome da lista criada
        val nomeListaSharedPreference: SharedPreferences =
            this.getSharedPreferences("lista", MODE_PRIVATE)
        val nomeLista: String? = nomeListaSharedPreference.getString("nome_lista", "")

        //Imprimindo o nome da lista
        txtNomeLista.text = nomeLista

        //Finalizando o app
        btn_finaliza.setOnClickListener{
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish();

            Toast.makeText(this@ListaActivity,"Volte sempre", Toast.LENGTH_LONG).show()

        }
    }

}
