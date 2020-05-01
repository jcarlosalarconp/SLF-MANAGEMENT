package com.example.slf_management.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.slf_management.R
import com.example.slf_management.adapter.ExpandibleListViewAdapter
import kotlinx.android.synthetic.main.activity_material.*
import java.util.ArrayList

class MaterialActivity : AppCompatActivity() {

    private val nombreMaterialActivity by lazy { findViewById<TextView>(R.id.nombreMaterialActivity) }
    private val imagenMaterialActivity by lazy { findViewById<ImageView>(R.id.imagenMaterialActivity) }
    val header : MutableList<String> = ArrayList ()
    val body : MutableList<MutableList<String>> = ArrayList ()

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

        val listaComentarios : MutableList<String> = ArrayList()
        listaComentarios.add("Me gusta")
        listaComentarios.add("No me gusta")
        listaComentarios.add("Me gusta")
        listaComentarios.add("No me gusta")
        listaComentarios.add("Me gusta")
        listaComentarios.add("No me gusta")
        listaComentarios.add("Me gusta")
        listaComentarios.add("No me gusta")
        listaComentarios.add("Me gusta")
        listaComentarios.add("No me gusta")

        val listaEventos : MutableList<String> = ArrayList()
        listaEventos.add("cumple ale")
        listaEventos.add("comunion juanka")

        header.add("Comentarios")
        header.add("Eventos")

        body.add(listaComentarios)
        body.add(listaEventos)

        expandibleListViewMaterial.setAdapter(ExpandibleListViewAdapter(this, expandibleListViewMaterial, header, body))
    }

}
