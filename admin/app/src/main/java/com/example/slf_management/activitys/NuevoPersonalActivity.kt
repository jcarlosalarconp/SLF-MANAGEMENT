package com.example.slf_management.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.slf_management.R
import com.example.slf_management.adapter.NuevoElementoItemAdapter
import com.example.slf_management.items.NuevoElementoItem
import kotlinx.android.synthetic.main.activity_nuevo_personal.*
import java.util.ArrayList

class NuevoPersonalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_personal)

        var listaElementos: ArrayList<NuevoElementoItem> = arrayListOf()

        val elemento1 = NuevoElementoItem("Nombre", "")
        val elemento2 = NuevoElementoItem("Teléfono", "")
        val elemento3 = NuevoElementoItem("DNI", "")
        val elemento4 = NuevoElementoItem("Dirección", "")
        val elemento5 = NuevoElementoItem("Tlf. contacto externo", "")
        val elemento6 = NuevoElementoItem("Nº Seguridad Social", "")
        val elemento7 = NuevoElementoItem("Activo", "")

        listaElementos.add(elemento1)
        listaElementos.add(elemento2)
        listaElementos.add(elemento3)
        listaElementos.add(elemento4)
        listaElementos.add(elemento5)
        listaElementos.add(elemento6)
        listaElementos.add(elemento7)

        val adapter = NuevoElementoItemAdapter(listaElementos)
        val recycler = recyclerNuevoPersonal.findViewById<androidx.recyclerview.widget.RecyclerView>(com.example.slf_management.R.id.recyclerNuevoPersonal)
        val layoutManager= LinearLayoutManager(this@NuevoPersonalActivity, LinearLayoutManager.VERTICAL, false)
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
    }
}