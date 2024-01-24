package com.example.clima

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val tvUser = findViewById<TextView>(R.id.tvnameUser)
        val lVPaises = findViewById<ListView>(R.id.lvPaises)
        val paises= listOf<String>("Ecuador","Peru","Colombia", "Venezuela","Argentina","Chile","Brazil","Paraguay", "Uruguay","Guyanas","Panama")//,"Guatemala","México","Honduras","Puerto Rico","Canada", "Haitì")
        paises.sorted()
        val paisesDataAdapter = ArrayAdapter(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item,paises)
        spinner.adapter= paisesDataAdapter
        lVPaises.adapter=paisesDataAdapter

        // Guardar un valor en SharedPreferences
        val storage = getSharedPreferences("DATOS", Context.MODE_PRIVATE)//0
        storage.edit().putString("name", "Cristian").apply()
        tvUser.text = storage.getString("name","NO HAY NOMBRE")

        // Configurar el clic en elementos del ListView si es necesario
        lVPaises.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = paises[position]
            Toast.makeText(this, "Seleccionado: $selectedItem", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Clima::class.java)
            intent.putExtra("pais",selectedItem)
            when (position) {
                0 ->{
                    intent.putExtra("grados","40º")
                    intent.putExtra("clima","Soleado")
                }
                1 -> {
                    intent.putExtra("grados","20º")
                    intent.putExtra("clima","Despejado")
                }
                2 -> {
                    intent.putExtra("grados","10º")
                    intent.putExtra("clima","Nublado")
                }
                else -> println("Otros")
            }
            startActivity(intent)
        }

    }
}
/*
fun cargar listView(){
   val listView: ListView = findViewById(R.id.listView)

    // Datos de ejemplo
    val datos = arrayOf("Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4")

    // Crear y configurar el adaptador por defecto (ArrayAdapter)
    val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, datos)
    listView.adapter = adaptador

    // Configurar el clic en elementos del ListView si es necesario
    listView.setOnItemClickListener { _, _, position, _ ->
        val selectedItem = datos[position]
        Toast.makeText(this, "Seleccionado: $selectedItem", Toast.LENGTH_SHORT).show()
    }
    println("hi")
}*/