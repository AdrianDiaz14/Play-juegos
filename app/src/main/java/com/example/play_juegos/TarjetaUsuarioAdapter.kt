package com.example.play_juegos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TarjetaUsuarioAdapter(var usuariosList: List<TarjetaUsuarios>, val onClick: (View) -> Unit) : RecyclerView.Adapter<TarjetaUsuarioAdapter.TarjUsuarioViewHolder>() {

    //Gestiona los componentes visuales de cada elemento
    class TarjUsuarioViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombre = view.findViewById<TextView>(R.id.nombreUsuario)
        val puntuacion = view.findViewById<TextView>(R.id.puntuacionUsuario)
        val imagen = view.findViewById<ImageView>(R.id.imagenUsuario)

        fun render(usuariosModel: TarjetaUsuarios, onClick: (View) -> Unit) = with(itemView){
            nombre.text = usuariosModel.nombre
            puntuacion.text = usuariosModel.puntuacion.toString()
            imagen.setImageResource(usuariosModel.imagen)
            setOnClickListener{ onClick(itemView)}
        }
    }

    //Crea la vista para un elemento del RecyclerView
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjUsuarioViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_usuarios, viewGroup, false)
        return TarjUsuarioViewHolder(itemView)
    }

    //Asigna los datos de cada elemento según su posición
    override fun onBindViewHolder(viewHolder: TarjUsuarioViewHolder, pos: Int) {
        val item = usuariosList.get(pos)
        viewHolder.render(item, onClick)
    }

    //Obtiene el número de elemento que compondrán el RecyclerView
    override fun getItemCount(): Int {
        return usuariosList.size
    }
}