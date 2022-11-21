package com.example.e_conomiza.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.e_conomiza.Interface.RetrofitFactory
import com.example.e_conomiza.R
import com.example.e_conomiza.model.Produto
import com.example.e_conomiza.model.ProdutoLista
import okhttp3.ResponseBody
import retrofit2.*
import java.security.AccessController.getContext


class NovaListaActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova_lista)

        // Escondendo a barra de Ação
        supportActionBar!!.hide()



        //Declarando as variáveis
        val txtNomeLista: TextView = findViewById(R.id.txt_nome_lista_nova)
        val txtNomeProduto: EditText = findViewById(R.id.edt_nome_produto)
        val btnSalvarLista: Button = findViewById(R.id.btn_salvar_lista)
        val btnPesquisar: Button = findViewById(R.id.btn_pesquisar)
        val progressBarProduto: ProgressBar = findViewById(R.id.progress_bar_produto)
        var txtGetProd: TextView = findViewById(R.id.txt_getProd)
        var txtGetMarca: TextView = findViewById(R.id.txt_getMarca)
        var txtGetId: TextView = findViewById(R.id.txt_getId)
        val btnAdicionarProd: Button = findViewById(R.id.btn_adicionar)
        var spinner_prod: Spinner = findViewById(R.id.spinner_prod)
        var cardProd : CardView = findViewById(R.id.card_produto)

        // Escondendo o botão de adicionar produto
        btnAdicionarProd.visibility = View.INVISIBLE
        spinner_prod.visibility = View.INVISIBLE

        btnSalvarLista.setOnClickListener {
            val m = Intent(this, ProdutosActivity::class.java)
            startActivity(m)
        }

        //Recuperando o nome da lista criada
        val nomeListaSharedPreference: SharedPreferences =
            this.getSharedPreferences("lista", MODE_PRIVATE)
        val nomeLista: String? = nomeListaSharedPreference.getString("nome_lista", "")

        //Imprimindo o nome da lista
        txtNomeLista.text = nomeLista

        // Pesquisando o Produto(GET)
        btnPesquisar.setOnClickListener {

            // Deixar visível a barra de progresso
            progressBarProduto.visibility = View.VISIBLE
            //cardProd.visibility = View.VISIBLE


            // Criando uma variável que vai receber o nome do produto
            val nome: String = txtNomeProduto.text.toString()
            // Chamando a API
            val call = RetrofitFactory().produtoApi().getProdutoNome(nome)
            println(nome)

            call.enqueue(object : Callback<List<Produto>> {
                override fun onResponse(
                    call: Call<List<Produto>>,
                    response: Response<List<Produto>>
                ) {
                    response.body()?.let {
                        Log.i("nome", it.toString())
                        var produto = Produto(0, "", "")
                        cardProd.visibility = View.VISIBLE
                        for (i in it.toMutableList().indices) {
                            println("Entrei")
                            produto = it.toMutableList().get(i)
                            //Imprimindo o nome da lista
                            txtGetProd.text = produto.nomeProduto
                            txtGetMarca.text = produto.marca
                            txtGetId.text = produto.id.toString()
                            println(produto.nomeProduto)
                            btnAdicionarProd.visibility = View.VISIBLE
                            Toast.makeText(
                                this@NovaListaActivity,
                                it.toString(),
                                Toast.LENGTH_LONG
                            )
                                .show()
                        }
                    } ?: Toast.makeText(
                        this@NovaListaActivity,
                        "Produto não localizado",
                        Toast.LENGTH_LONG
                    ).show()
                    progressBarProduto.visibility = View.INVISIBLE
                    //println(response.body().toString())
                }

                override fun onFailure(call: Call<List<Produto>>, t: Throwable) {
                    t?.message?.let { it1 -> Log.e("Erro", it1) }
                    progressBarProduto.visibility = View.INVISIBLE
                }

            })

            //Adicionando o Produto na lista
            var produtoLista = ProdutoLista(0, 0, 5)

            btnAdicionarProd.setOnClickListener {
                val call2 = RetrofitFactory().produtoListaApi().gravarProdutoLista(produtoLista)
                call2.enqueue(object : Callback<ProdutoLista> {
                    override fun onResponse(
                        call: Call<ProdutoLista>,
                        response: Response<ProdutoLista>
                    ) {
                        val addedListaProduto = response.body()
                        response.body()?.let {
                            Log.i("nome", it.toString())
                            Toast.makeText(this@NovaListaActivity, it.toString(), Toast.LENGTH_LONG)
                                .show()
                            progressBarProduto.visibility = View.INVISIBLE
                        } ?: Toast.makeText(
                            this@NovaListaActivity,
                            "Produto adicionado com sucesso",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    override fun onFailure(call: Call<ProdutoLista>, t: Throwable) {
                        t?.message?.let { it1 -> Log.e("Erro", it1) }
                        progressBarProduto.visibility = View.INVISIBLE
                    }

                })
            }
        }
    }
}



















