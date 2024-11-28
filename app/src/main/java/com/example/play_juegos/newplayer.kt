package com.example.play_juegos

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class newplayer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.newplayer)

        // Configura la Toolbar como ActionBar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Configura spinner
        val telefonos = arrayOf("Teléfono 1", "Teléfono 2", "Teléfono 3", "Teléfono 4", "Teléfono 5")
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, telefonos)

        val list_telefonos = findViewById(R.id.spinner) as Spinner
        list_telefonos.adapter = adaptador
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        // Mostrar el item seleccionado en el recuadro
        val editTextPhone = findViewById<EditText>(R.id.editTextPhone)
        list_telefonos.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val telefonoSeleccionado = parent!!.getItemAtPosition(position).toString()
                editTextPhone.setText(telefonoSeleccionado)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        })
    }
}