package com.example.slf_management.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.slf_management.R
import com.example.slf_management.adapter.NuevoElementoItemAdapter
import com.example.slf_management.items.NuevoElementoItem
import kotlinx.android.synthetic.main.activity_nuevo_evento.*
import kotlinx.android.synthetic.main.activity_nuevo_personal.*
import java.util.ArrayList

class NuevoEventoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_evento)
        /**
         * CREACIÓN DE LISTA E ITEMS (CAMBIAR POR BASE DE DATOS)
         */
        var listaElementos: ArrayList<NuevoElementoItem> = arrayListOf()

        val elemento1 = NuevoElementoItem("Dirección de Celebración", "")
        val elemento2 = NuevoElementoItem("Hora de comienzo", "")
        val elemento3 = NuevoElementoItem("Nº de Festejados", "")
        val elemento4 = NuevoElementoItem("Festejado", "")
        val elemento5 = NuevoElementoItem("Observaciones", "")
        val elemento6 = NuevoElementoItem("Nombre del Cliente", "")
        val elemento7 = NuevoElementoItem("DNI del Cliente", "")
        val elemento8 = NuevoElementoItem("Teléfono del Cliente", "")

        /**
         * INSERTANDO ITEMS EN LISTA
         */
        listaElementos.add(elemento1)
        listaElementos.add(elemento2)
        listaElementos.add(elemento3)
        listaElementos.add(elemento4)
        listaElementos.add(elemento5)
        listaElementos.add(elemento6)
        listaElementos.add(elemento7)
        listaElementos.add(elemento8)

        /**
         * SINCRONIZACIÓN CON LOS ADAPTERS
         */
        val adapter = NuevoElementoItemAdapter(listaElementos)
        val recycler = recyclerNuevoEvento.findViewById<androidx.recyclerview.widget.RecyclerView>(com.example.slf_management.R.id.recyclerNuevoEvento)
        val layoutManager= LinearLayoutManager(this@NuevoEventoActivity, LinearLayoutManager.VERTICAL, false)
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter

        /**
         * BOTON
         */
        val buttonAceptar = findViewById<Button>(R.id.buttonAceptarNuevoEvento)
        buttonAceptar.setOnClickListener{
            Toast.makeText(this, "Evento añadido", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}