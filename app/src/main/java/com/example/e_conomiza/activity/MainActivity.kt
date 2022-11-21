package com.example.e_conomiza.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.e_conomiza.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        val btnEntrar: Button = findViewById(R.id.btn_entrar)

        btnEntrar.setOnClickListener{
            val i = Intent(this, CriarListaActivity::class.java)
            startActivity(i)


        }
    }
}