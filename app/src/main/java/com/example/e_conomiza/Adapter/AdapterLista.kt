// package com.example.e_conomiza.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_conomiza.R
import com.example.e_conomiza.model.Lista
import com.example.e_conomiza.model.Produto

//Método construtor : Classe Adapter herdando da classe RecyclerView
//class AdapterLista (private val context: Context, private val listas: MutableList<Lista>): RecyclerView.Adapter<AdapterLista.ListaViewHolder>() {

    // Método que cria o item para a vizualização em tela
  //  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
  //      val itemLista = LayoutInflater.from(context).inflate(R.layout.listas_itens, parent, false)
    //    val holder = ListaViewHolder((itemLista))
      //  return holder
    //}

    // Método que exibi as vizualizações para o usuário
    //override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
      //  holder.nome.text = listas[position].nomeLista
    //}

    // Método que vai passar o tamanho da lista
    //override fun getItemCount(): Int = listas.size


    // Criando uma classe interna que herda as características da classe RecyclerView
    //inner class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      //  val nome = itemView.findViewById<EditText>(R.id.txt_nova_lista)
    //}
//}