package com.example.slf_management.activitys

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.slf_management.R
import com.example.slf_management.adapter.ExpandibleListViewAdapter
import com.example.slf_management.items.ComentarioItem
import com.example.slf_management.items.MaterialItem
import kotlinx.android.synthetic.main.activity_material.*
import java.time.LocalDate
import java.util.ArrayList

class MaterialActivity : AppCompatActivity() {

    private val nombreMaterialActivity by lazy { findViewById<TextView>(R.id.nombreMaterialActivity) }
    private val imagenMaterialActivity by lazy { findViewById<ImageView>(R.id.imagenMaterialActivity) }
    val header : MutableList<String> = ArrayList ()
    val body : MutableList<MutableList<ComentarioItem>> = ArrayList ()

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

        listaComentarios.add(comentario)
        listaComentarios.add(comentario2)
        listaComentarios.add(comentario3)

        val listaEventos : MutableList<String> = ArrayList()
        listaEventos.add("Cumpleaños Alejando")
        listaEventos.add("Comunión Nadia")

        header.add("Comentarios")
        //header.add("Eventos")

        body.add(listaComentarios)
        //body.add(listaEventos)

        expandibleListViewMaterial.setAdapter(ExpandibleListViewAdapter(this, expandibleListViewMaterial, header, body))
    }

}
