package com.example.slf_management.activitys

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.slf_management.R
import com.example.slf_management.adapter.ListaComentariosAdapter
import com.example.slf_management.adapter.ListaEventosAdapter
import com.example.slf_management.items.ComentarioItem
import com.example.slf_management.items.EventoItem
import kotlinx.android.synthetic.main.activity_material.*
import java.time.LocalDate
import java.util.ArrayList

class MaterialActivity : AppCompatActivity() {

    private val nombreMaterialActivity by lazy { findViewById<TextView>(R.id.nombreMaterialActivity) }
    private val imagenMaterialActivity by lazy { findViewById<ImageView>(R.id.imagenMaterialActivity) }
    val header : MutableList<String> = ArrayList ()
    val headerEvento : MutableList<String> = ArrayList ()
    val body : MutableList<MutableList<ComentarioItem>> = ArrayList ()
    val bodyEvento : MutableList<MutableList<EventoItem>> = ArrayList ()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material)
        intent.extras?.let {
            val nombreMaterial = it.getString("nombreMaterial")
            val imagenMaterial = it.getInt("imagenMaterial")
            nombreMaterialActivity.text = nombreMaterial
            imagenMaterialActivity.setImageResource(imagenMaterial)
        }

        title = "Material"

        val listaComentarios : MutableList<ComentarioItem> = ArrayList()
        val comentario = ComentarioItem("Juan Carlos", "Cable roto", LocalDate.now())
        val comentario2 = ComentarioItem("Javier", "Rotura lateral", LocalDate.now())
        val comentario3 = ComentarioItem("Lorena", "Falta corriente", LocalDate.now())
        val comentario4 = ComentarioItem("Juan Carlos", "Cable roto", LocalDate.now())
        val comentario5 = ComentarioItem("Javier", "Rotura lateral", LocalDate.now())
        val comentario6 = ComentarioItem("Lorena", "Falta corriente", LocalDate.now())

        listaComentarios.add(comentario)
        listaComentarios.add(comentario2)
        listaComentarios.add(comentario3)
        listaComentarios.add(comentario4)
        listaComentarios.add(comentario5)
        listaComentarios.add(comentario6)

        val listaEventos : MutableList<EventoItem> = ArrayList()
        val evento1 = EventoItem(1, "Show de Funky", "Málaga", LocalDate.now())
        val evento2 = EventoItem(2, "Show de Wiwi", "Pizarra", LocalDate.now())
        val evento3 = EventoItem(3, "Show de Rickypin", "San Pedro", LocalDate.now())
        val evento4 = EventoItem(4, "Show de Candy", "Alhaurin el Grande", LocalDate.now())

        listaEventos.add(evento1)
        listaEventos.add(evento2)
        listaEventos.add(evento3)
        listaEventos.add(evento4)

        header.add("Comentarios")
        headerEvento.add("Eventos")

        body.add(listaComentarios)
        bodyEvento.add(listaEventos)

        expandibleListViewMaterial.setAdapter(ListaComentariosAdapter(this, expandibleListViewMaterial, header, body))
        expandibleListViewMaterial2.setAdapter(ListaEventosAdapter(this, expandibleListViewMaterial2, headerEvento, bodyEvento))
    }

}
