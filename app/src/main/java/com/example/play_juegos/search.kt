package com.example.play_juegos

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton

class search : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.search)

        val chipGroup = findViewById<ChipGroup>(R.id.chipGroup)
        val fab: FloatingActionButton = findViewById(R.id.fab)
/*        val chipXBOX = findViewById<Chip>(R.id.chipXBOX)

        chipXBOX.setOnClickListener {
            val chipXBOXText = chipXBOX.text.toString()
            Toast.makeText(this, "Has pulsado el chip $chipXBOXText", Toast.LENGTH_SHORT).show()
        }
*/

        //Muestra un Toast con el nombre del item seleccionado en el ChipGroup
        chipGroup.setOnCheckedStateChangeListener { group, checkedIds ->
                val chipSeleccionado = findViewById<Chip>(checkedIds[0])
                val chipText = chipSeleccionado.text.toString()
                Toast.makeText(this, "$chipText", Toast.LENGTH_SHORT).show()
        }

        //Muestra un Toast cuando se pulsa el fab inferior
        fab.setOnClickListener {
            Toast.makeText(this, "Se ha pulsado el botón", Toast.LENGTH_SHORT).show()

            //Define la trayectoria del fab al ser pulsado
            fab.animate()
                .translationYBy(-150f)
                .setDuration(500)
                .withEndAction {
                    fab.animate()
                        .translationYBy(150f)
                        .setDuration(300)
                        .start()
                }
                .start()
        }

        val items = ArrayList<Tarjeta>()
        items.add(Tarjeta(R.string.note1))
        items.add(Tarjeta(R.string.note2))
        items.add(Tarjeta(R.string.note3))
        items.add(Tarjeta(R.string.note4))
        items.add(Tarjeta(R.string.note5))
        items.add(Tarjeta(R.string.note6))
        items.add(Tarjeta(R.string.note7))
        items.add(Tarjeta(R.string.note8))
        items.add(Tarjeta(R.string.note9))

        val recView = findViewById<RecyclerView>(R.id.recyclerViewGeneros)
        recView.setHasFixedSize(true)

        val adaptador = CardsAdapter(items)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //Muestra un Toast con el nombre del elemento seleccionado en el RecyclerView
        adaptador.onClick = {
            val position = recView.getChildAdapterPosition(it)
            if (position != RecyclerView.NO_POSITION) {
                val tarjeta = items[position]
                val texto = getString(tarjeta.texto)
                Toast.makeText(this@search, texto, Toast.LENGTH_LONG).show()
            }
        }
    }
}