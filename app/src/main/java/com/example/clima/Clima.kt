package com.example.clima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Clima : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clima)
        val tvPais= findViewById<TextView>(R.id.tvPais)
        val tvTemperatura= findViewById<TextView>(R.id.tvTemperatura)
        val tvClima= findViewById<TextView>(R.id.tvClima)
        val atras = findViewById<ImageView>(R.id.imageView)
        val climas = listOf<String>("Soleado","Nublado", "Despejado", "Lluvioso")


        tvPais.text = intent.getStringExtra("pais")
        tvTemperatura.text =  intent.getStringExtra("grados")?: (2..50).random().toString()
        tvClima.text =  intent.getStringExtra("clima")?:climas[(0..climas.size-1).random()]
        atras.setOnClickListener {
            finish()
        }
    }
}