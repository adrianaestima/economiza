package com.example.e_conomiza.activity

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.content.Intent
import com.example.e_conomiza.R

class ListaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        // Escondendo a barra de Ação
        supportActionBar!!.hide()

        // Declarando as variáveis
        val txtLista : TextView = findViewById(R.id.txt_lista)
        val btnSalvarProduto : Button = findViewById(R.id.btn_salvar_lista)
        val spnProdQuant : Spinner = findViewById(R.id.prod_quant)
        val btnFinalizar : Button = findViewById(R.id.btn_finalizar)

        // Recuperando o nome da lista
        val listaSharedPreference : SharedPreferences = this.getSharedPreferences("lista", MODE_PRIVATE)
        val lista : String? = listaSharedPreference.getString( "nome_lista", "")

        //Imprimindo o nome da lista
        txtLista.text = lista

        /* Acessando o banco de dados
        fun getProduto(){
            val retrofitProduto = Utils.getRetrofitInstance(path ="https://economiza.azurewebsites.net/")
            val endpoint = retrofitProduto.create<

            endpoint.getProduto().enqueue(object : Callback<JsonObject> {
                override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                    var data = mutableListOf<String>()
                    response.body()?.keySet()?.iterator()?.forEach {
                        data.add(it)
                    }
                    println(data.count())
                }

                override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                    println("Não foi")
        */
        // Método que busca o nome do produto
        val produtoSharedPreference : SharedPreferences = this.getSharedPreferences("produto", MODE_PRIVATE)
        val produto : String? = produtoSharedPreference.getString( "nome_produto", "")

        // Salvando a quantidade de produto
        btnSalvarProduto.setOnClickListener {

            val quantPersistencia: SharedPreferences =
                this.getSharedPreferences("quantidade", Context.MODE_PRIVATE)
            val editor = quantPersistencia.edit()
            editor.putString("quantidade", spnProdQuant.selectedItem.toString())
            editor.apply()

            // Mensagem que mostra que a quantidade foi salva
            Toast.makeText(this, "Salvo com sucesso", Toast.LENGTH_SHORT).show()
        }
        /* Passando para a próxima tela
        btnFinalizar.setOnClickListener{
            val l = Intent(this, CompararPrecoActivity ::class.java)
            startActivity(l)
        }*/

    }

}
    //Buscar a lista com os produtos ( Get By IdLista)