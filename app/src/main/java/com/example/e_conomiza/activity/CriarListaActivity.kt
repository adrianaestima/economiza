package com.example.e_conomiza.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.e_conomiza.Interface.RetrofitFactory
import com.example.e_conomiza.R
import com.example.e_conomiza.model.Lista
import com.example.e_conomiza.model.Produto
import com.example.e_conomiza.model.ProdutoLista
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body


class CriarListaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_lista)

        // Escondendo a barra de Ação
        supportActionBar!!.hide()

        // Declarando as variáveis
        val btnCriar: Button = findViewById(R.id.btn_criar)
        val edtNomeLista: EditText = findViewById(R.id.edt_nome_lista)
        val edtIdLista: TextView = findViewById(R.id.edt_id_lista)

        // val btnFotosGaleria : Button = findViewById<Button>(R.id.btn_fotos_galeria)
        //val btnFotosWeb : Button = findViewById<Button>(R.id.btn_fotos_web)
        //val imgFotoGaleria : ImageView = findViewById<ImageView>(R.id.img_fotoGaleria)

        // Gravando o nome da lista
        btnCriar.setOnClickListener {


            val listaPersistencia: SharedPreferences =
                this.getSharedPreferences("lista", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = listaPersistencia.edit()

            editor.putString("nome_lista", edtNomeLista.editableText.toString())
            editor.apply()

            val listaId: SharedPreferences =
                this.getSharedPreferences("listaId", Context.MODE_PRIVATE)

            // Mensagem que avisa o usuário que a tela foi salva cim sucesso
            Toast.makeText(this, "lista salva com sucesso", Toast.LENGTH_SHORT).show()


            //Adicionando o nome da lista

            val call = RetrofitFactory().listaApi().gravarLista(edtNomeLista.editableText.toString())
            call.enqueue(object : Callback<Lista> {
                override fun onResponse(
                    call: Call<Lista>,
                    response: Response<Lista>
                ) {
                    val addedListaProduto = response.body()
                    response.body()?.let {
                        Log.i("nome", it.toString())
                        var listaNew = Lista(0,"")
                        listaNew.idLista = it.idLista
                        val editor2: SharedPreferences.Editor = listaId.edit()
                        editor2.putString("id_lista", listaNew.idLista.toString())
                        editor2.apply()
                        Toast.makeText(this@CriarListaActivity, it.toString(), Toast.LENGTH_LONG)
                            .show()
                   } ?: Toast.makeText(
                        this@CriarListaActivity,
                        "Erro ao gravar Lista",
                        Toast.LENGTH_LONG
                    ).show()
                }
                override fun onFailure(call: Call<Lista>, t: Throwable) {
                    t?.message?.let { it1 -> Log.e("Erro", it1) }
                }

            })
            val j = Intent(this, NovaListaActivity::class.java)
            startActivity(j)
        }
    }

}