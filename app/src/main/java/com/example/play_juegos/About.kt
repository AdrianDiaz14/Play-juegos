package com.example.play_juegos

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class About : AppCompatActivity() {

    // Guarda en una lista cada item contenido en el RecyclerView
    val usuarios = listOf<TarjetaUsuarios> (
        TarjetaUsuarios(
            "María Mata",
            2014,
            R.drawable.image1
        ),
        TarjetaUsuarios(
            "Antonio Sanz",
            1890,
            R.drawable.image2
        ),
        TarjetaUsuarios(
            "Carlos",
            967,
            R.drawable.image3
        ),
        TarjetaUsuarios(
            "Berta",
            945,
            R.drawable.image4
        ),
        TarjetaUsuarios(
            "Héctor Campos",
            879,
            R.drawable.image5
        ),
        TarjetaUsuarios(
            "Ismael",
            678,
            R.drawable.image6
        ),
        TarjetaUsuarios(
            "Juan José",
            556,
            R.drawable.image7
        ),
        TarjetaUsuarios(
            "Claudia M.",
            335,
            R.drawable.image8
        )

    )

    // Inicializa la actividad justo antes de mostrarla en pantalla
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            enableEdgeToEdge()
            setContentView(R.layout.about)
            initRecyclerView()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    // Inicializa y configura el RecyclerView
    fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerUsuarios)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = TarjetaUsuarioAdapter(usuarios) { view ->
            val nombreUsuario = (view.findViewById<TextView>(R.id.nombreUsuario)).text.toString()
            Toast.makeText(this, nombreUsuario, Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = adapter
    }
}