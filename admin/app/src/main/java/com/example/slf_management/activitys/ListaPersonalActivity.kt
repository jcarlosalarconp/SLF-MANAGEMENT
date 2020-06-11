package com.example.slf_management.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.slf_management.R
import com.example.slf_management.adapter.SectionRecyclerViewFichaAdapter
import com.example.slf_management.adapter.SectionRecyclerViewTrabajadorAdapter
import com.example.slf_management.items.FichaItem
import kotlinx.android.synthetic.main.activity_lista_personal.*

class ListaPersonalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_personal)

        var listaTrabajadores:ArrayList<FichaItem> = arrayListOf()

        val trabajador1 = FichaItem(R.drawable.personal_icon, "Juan Carlos")
        val trabajador2 = FichaItem(R.drawable.personal_icon, "Javier")
        val trabajador3 = FichaItem(R.drawable.personal_icon, "Ricardo")
        val trabajador4 = FichaItem(R.drawable.personal_icon, "Paz")
        val trabajador5 = FichaItem(R.drawable.personal_icon, "Lorena")
        val trabajador6 = FichaItem(R.drawable.personal_icon, "Maria")

        listaTrabajadores.add(trabajador1)
        listaTrabajadores.add(trabajador2)
        listaTrabajadores.add(trabajador3)
        listaTrabajadores.add(trabajador4)
        listaTrabajadores.add(trabajador5)
        listaTrabajadores.add(trabajador6)

        val adapterTrabajador = SectionRecyclerViewFichaAdapter(listaTrabajadores)
        val recyclerTrabajador = recyclerListaTrabajadores.findViewById<RecyclerView>(R.id.recyclerListaTrabajadores)
        val layoutManagerTrabajador = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerTrabajador.layoutManager = layoutManagerTrabajador
        recyclerTrabajador.adapter = adapterTrabajador
    }
}
