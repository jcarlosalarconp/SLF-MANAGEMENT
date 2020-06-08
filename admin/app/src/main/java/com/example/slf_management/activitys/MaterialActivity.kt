package com.example.slf_management.activitys

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.slf_management.R
import com.example.slf_management.adapter.SectionRecyclerViewComentariosAdapter
import com.example.slf_management.adapter.SectionRecyclerViewEventosAdapter
import com.example.slf_management.items.Comentario
import com.example.slf_management.items.Evento
import kotlinx.android.synthetic.main.activity_material.*
import java.time.LocalDate
import java.util.*

class MaterialActivity : AppCompatActivity() {

    private val nombreMaterialActivity by lazy { findViewById<TextView>(R.id.nombreMaterialActivity) }
    private val imagenMaterialActivity by lazy { findViewById<ImageView>(R.id.imagenMaterialActivity) }
    private var mostrarComentarios = true
    private var mostrarEventos = true

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

        val listaComentarios : ArrayList<Comentario> = arrayListOf()
        val comentario = Comentario("Juan Carlos", "Cable roto", LocalDate.now())
        val comentario2 = Comentario("Javier", "Rotura lateral", LocalDate.now())
        val comentario3 = Comentario("Lorena", "Falta corriente", LocalDate.now())
        val comentario4 = Comentario("Juan Carlos", "Cable roto", LocalDate.now())
        val comentario5 = Comentario("Javier", "Rotura lateral", LocalDate.now())
        val comentario6 = Comentario("Lorena", "Falta corriente", LocalDate.now())

        listaComentarios.add(comentario)
        listaComentarios.add(comentario2)
        listaComentarios.add(comentario3)
        listaComentarios.add(comentario4)
        listaComentarios.add(comentario5)
        listaComentarios.add(comentario6)

        val listaEventos : ArrayList<Evento> = arrayListOf()
        val evento1 = Evento(1, "Show de Funky", "Málaga", LocalDate.now())
        val evento2 = Evento(2, "Show de Wiwi", "Pizarra", LocalDate.now())
        val evento3 = Evento(3, "Show de Rickypin", "San Pedro", LocalDate.now())
        val evento4 = Evento(4, "Show de Candy", "Alhaurin el Grande", LocalDate.now())

        listaEventos.add(evento1)
        listaEventos.add(evento2)
        listaEventos.add(evento3)
        listaEventos.add(evento4)

        val adapterComentarios = SectionRecyclerViewEventosAdapter(listaEventos)
        val recyclerMenuComentarios = listaComentario.findViewById<RecyclerView>(R.id.recyclerMenu)
        val layoutManagerComentarios = LinearLayoutManager(this@MaterialActivity, LinearLayoutManager.VERTICAL, false)
        recyclerMenuComentarios.layoutManager = layoutManagerComentarios
        recyclerMenuComentarios.adapter = adapterComentarios
        recyclerMenuComentarios.visibility = View.VISIBLE
        listaComentario.setOnClickListener(object : View.OnClickListener{

            override fun onClick(v: View?) {

                if (!mostrarComentarios) {
                    recyclerMenuComentarios.visibility = View.VISIBLE
                    mostrarComentarios = true
                }
                else {
                    recyclerMenuComentarios.visibility = View.GONE
                    mostrarComentarios = false
                }
            }
        })
        val textoComentario = listaComentario.findViewById<TextView>(R.id.tituloMenu)
        textoComentario.text = "Comentarios"


        val adapter = SectionRecyclerViewComentariosAdapter(listaComentarios)
        val recyclerMenu = listaEvento.findViewById<RecyclerView>(R.id.recyclerMenu)
        val layoutManager = LinearLayoutManager(this@MaterialActivity, LinearLayoutManager.VERTICAL, false)
        recyclerMenu.layoutManager = layoutManager
        recyclerMenu.adapter = adapter
        recyclerMenu.visibility = View.VISIBLE

        listaEvento.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

                if (!mostrarEventos) {
                    recyclerMenu.visibility = View.VISIBLE
                    mostrarEventos = true
                }
                else {
                    recyclerMenu.visibility = View.GONE
                    mostrarEventos = false
                }
            }
        })
        val textoEvento = listaEvento.findViewById<TextView>(R.id.tituloMenu)
        textoEvento.text = "Eventos"

    }

}
