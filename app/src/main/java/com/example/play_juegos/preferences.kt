package com.example.play_juegos

import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class preferences : AppCompatActivity() {
    var puntuacion = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.preferences)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar1)
        val seekBar = findViewById<SeekBar>(R.id.seekBar1)
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        fab.setOnClickListener {
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            if (selectedRadioButtonId == -1) {

                Toast.makeText(applicationContext, "No has pulsado ninguna opción", Toast.LENGTH_LONG).show()
            } else {

                val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
                val selectedOption = selectedRadioButton.text.toString()


                val ratingSeekBar = seekBar.progress
                val ratingRatingBar = ratingBar.rating


                if(ratingSeekBar!=0){
                    Toast.makeText(applicationContext, " $selectedOption Puntuación $ratingSeekBar", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(applicationContext, " $selectedOption Puntuación $ratingRatingBar", Toast.LENGTH_LONG).show()
                }
            }
        }

        ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            puntuacion = rating.toInt()
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                seekBar.progress = progress.toInt()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        //RATTINGBAR
        val rb = findViewById(R.id.ratingBar1) as RatingBar
        rb.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
            rb.rating = rating.toFloat()
        }

        //SEEKBAR
        val sb = findViewById(R.id.seekBar1) as SeekBar
        sb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekbar: SeekBar, progress: Int, fromUser: Boolean) {
                sb.progress = progress.toInt()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }
}