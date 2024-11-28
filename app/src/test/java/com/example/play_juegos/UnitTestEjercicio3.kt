package com.example.play_juegos

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.kotlin.verify

@RunWith(AndroidJUnit4::class)
class UnitTestEjercicio3 {

    @Test
    fun testAdapterDisplaysCorrectData() {
        // Crear datos de prueba
        val usuariosList = listOf(
            TarjetaUsuarios("María Mata", 2014, R.drawable.image1),
            TarjetaUsuarios("Antonio Sanz", 1890, R.drawable.image2)
        )

        // Crear el adaptador con los datos
        val adapter = TarjetaUsuarioAdapter(usuariosList) {}

        // Crear un mock de la vista para verificar el comportamiento
        val viewHolder = mock(TarjetaUsuarioAdapter.TarjUsuarioViewHolder::class.java)
        val itemView = mock(View::class.java)
        val nombreTextView = mock(TextView::class.java)
        val puntuacionTextView = mock(TextView::class.java)
        val imagenImageView = mock(ImageView::class.java)

        Mockito.`when`(viewHolder.itemView).thenReturn(itemView)
        Mockito.`when`(itemView.findViewById<TextView>(R.id.nombreUsuario)).thenReturn(nombreTextView)
        Mockito.`when`(itemView.findViewById<TextView>(R.id.puntuacionUsuario)).thenReturn(puntuacionTextView)
        Mockito.`when`(itemView.findViewById<ImageView>(R.id.imagenUsuario)).thenReturn(imagenImageView)

        // Llamar al método render del ViewHolder con el primer item
        adapter.onBindViewHolder(viewHolder, 0)

        // Verificar que el nombre, puntuación e imagen están correctamente asignados
        verify(nombreTextView).setText("María Mata")
        verify(puntuacionTextView).setText("2014")
        verify(imagenImageView).setImageResource(R.drawable.image1)
    }

    @Test
    fun testItemClick() {
        // Crear datos de prueba
        val usuariosList = listOf(
            TarjetaUsuarios("María Mata", 2014, R.drawable.image1)
        )

        // Crear el adaptador
        val adapter = TarjetaUsuarioAdapter(usuariosList) { view ->
            val nombre = (view.findViewById<TextView>(R.id.nombreUsuario)).text.toString()
            // Aquí normalmente harías alguna aserción sobre el evento de clic, como un Toast
            // Verifica si el nombre se muestra correctamente al hacer clic
            assert(nombre == "María Mata")
        }

        // Crear un mock de la vista
        val viewHolder = mock(TarjetaUsuarioAdapter.TarjUsuarioViewHolder::class.java)
        val itemView = mock(View::class.java)
        Mockito.`when`(viewHolder.itemView).thenReturn(itemView)

        // Llamar al método render del ViewHolder con el primer item
        adapter.onBindViewHolder(viewHolder, 0)

        // Simular el clic
        viewHolder.itemView.performClick()
    }
}
