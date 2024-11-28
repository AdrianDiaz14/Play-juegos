package com.example.play_juegos

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.findViewTreeViewModelStoreOwner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val games = findViewById(R.id.button) as Button
        val jugador = findViewById(R.id.button1) as Button
        val prefs = findViewById(R.id.button2) as Button
        val about = findViewById(R.id.button3) as Button

        games.setOnClickListener {
            lanzarGames()
        }

        jugador.setOnClickListener {
            lanzarNewPlayer()
        }

        prefs.setOnClickListener {
            lanzarPreferencias()
        }

        about.setOnClickListener {
            lanzarAbout()
        }

        // Configura la Toolbar como ActionBar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Cambia la tipografía de la letra del titulo
        val titulo = findViewById<TextView>(R.id.titulo)
        titulo.typeface = ResourcesCompat.getFont(this, R.font.courgetteregular)

    }

    fun lanzarNewPlayer() {
        val i = Intent(this, newplayer::class.java)
        startActivity(i)
    }

    fun lanzarPreferencias() {
        val i = Intent(this, preferences::class.java)
        startActivity(i)
    }

    fun lanzarGames() {
        val i = Intent(this, games::class.java)
        startActivity(i)
    }

    fun lanzarAbout() {
        val i = Intent(this, About::class.java)
        startActivity(i)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // Controla el botón pulsado en el menú de la barra
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()

        if (id == R.id.action_buscar) {
            // Lanzar la actividad search
            val intent = Intent(this, search::class.java)
            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}