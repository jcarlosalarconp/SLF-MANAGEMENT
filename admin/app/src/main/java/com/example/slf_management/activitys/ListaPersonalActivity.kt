package com.example.slf_management.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.slf_management.R
import com.example.slf_management.adapter.TrabajadoresAdapter
import com.example.slf_management.items.FichaItem
import kotlinx.android.synthetic.main.activity_lista_personal.*

class ListaPersonalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_personal)

        /**
         * CREACIÓN DE LISTA E ITEMS (CAMBIAR POR BASE DE DATOS)
         */
        var listaTrabajadores:ArrayList<FichaItem> = arrayListOf()

        val trabajador1 = FichaItem(R.drawable.personal_icon, "Juan Carlos")
        val trabajador2 = FichaItem(R.drawable.personal_icon, "Javier")
        val trabajador3 = FichaItem(R.drawable.personal_icon, "Ricardo")
        val trabajador4 = FichaItem(R.drawable.personal_icon, "Paz")
        val trabajador5 = FichaItem(R.drawable.personal_icon, "Lorena")
        val trabajador6 = FichaItem(R.drawable.personal_icon, "Maria")

        /**
         * INSERTANDO ITEMS EN LISTA
         */
        listaTrabajadores.add(trabajador1)
        listaTrabajadores.add(trabajador2)
        listaTrabajadores.add(trabajador3)
        listaTrabajadores.add(trabajador4)
        listaTrabajadores.add(trabajador5)
        listaTrabajadores.add(trabajador6)

        /**
         * SINCRONIZACIÓN CON LOS ADAPTERS
         */
        val adapterTrabajador = TrabajadoresAdapter(listaTrabajadores)
        val recyclerTrabajador = recyclerListaTrabajadores.findViewById<RecyclerView>(R.id.recyclerListaTrabajadores)
        val layoutManagerTrabajador = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerTrabajador.layoutManager = layoutManagerTrabajador
        recyclerTrabajador.adapter = adapterTrabajador

        /**
         * FUNCION ONCLIC QUE AÑADE ITEM EN LISTA TRABAJADOR Y DEVUELVE A LA PANTALLA ANTERIOR
         */
        adapterTrabajador.setSectionRecyclerViewListener(object :TrabajadoresAdapter.SectionRecyclerViewListener{
            override fun onItemClick(itemPosition: Int) {
                //INSERT EN BASE DE DATOS
                adapterTrabajador.setlistaTrabajador(listaTrabajadores)
                Toast.makeText(this@ListaPersonalActivity, "Trabajador añadido", Toast.LENGTH_SHORT).show()
                finish()
            }
        })
    }
}
