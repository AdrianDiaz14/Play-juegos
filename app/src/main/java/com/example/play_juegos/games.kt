package com.example.play_juegos

import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class games : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.games)

        val floatingActionButton: FloatingActionButton = findViewById(R.id.floatingActionButton)

        floatingActionButton.setOnClickListener {

            val checkBoxAngryBirds: CheckBox = findViewById(R.id.checkBoxAngryBirds)
            val checkBoxDragonFly: CheckBox = findViewById(R.id.checkBoxDragonFly)
            val checkBoxHillClimbingRacing: CheckBox = findViewById(R.id.checkBoxHillClimbingRacing)
            val checkBoxRadiantDefense: CheckBox = findViewById(R.id.checkBoxRadiantDefense)
            val checkBoxPocketSoccer: CheckBox = findViewById(R.id.checkBoxPocketSoccer)
            val checkBoxNinjaJump: CheckBox = findViewById(R.id.checkBoxNinjaJump)
            val checkBoxAirControl: CheckBox = findViewById(R.id.checkBoxAirControl)

            val selectedOptions = mutableListOf<String>()

            if (checkBoxAngryBirds.isChecked) {
                selectedOptions.add(getString(R.string.angry_birds))
            }
            if (checkBoxDragonFly.isChecked) {
                selectedOptions.add(getString(R.string.dragon_fly))
            }
            if (checkBoxHillClimbingRacing.isChecked) {
                selectedOptions.add(getString(R.string.hill_climbing_racing))
            }
            if (checkBoxRadiantDefense.isChecked) {
                selectedOptions.add(getString(R.string.radiant_defense))
            }
            if (checkBoxPocketSoccer.isChecked) {
                selectedOptions.add(getString(R.string.pocket_soccer))
            }
            if (checkBoxNinjaJump.isChecked) {
                selectedOptions.add(getString(R.string.ninja_jump))
            }
            if (checkBoxAirControl.isChecked) {
                selectedOptions.add(getString(R.string.air_control))
            }

            // Mensaje Toast
            val message = when {
                selectedOptions.isEmpty() -> "No has elegido ninguna opción."
                selectedOptions.size == 1 -> "Has elegido ${selectedOptions[0]}"
                else -> {
                    val lastOption = selectedOptions.last()
                    val otherOptions = selectedOptions.dropLast(1).joinToString(", ")
                    "Has elegido $otherOptions y $lastOption"
                }
            }
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }

    }
}