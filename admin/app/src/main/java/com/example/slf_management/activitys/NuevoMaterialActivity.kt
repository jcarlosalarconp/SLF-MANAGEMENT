package com.example.slf_management.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.slf_management.R
import com.example.slf_management.adapter.NuevoElementoItemAdapter
import com.example.slf_management.items.NuevoElementoItem
import kotlinx.android.synthetic.main.activity_nuevo_material.*
import java.util.ArrayList

class NuevoMaterialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_material)

    var listaElementos: ArrayList<NuevoElementoItem> = arrayListOf()

    val elemento1 = NuevoElementoItem("Nombre", "")
    val elemento2 = NuevoElementoItem("Tipo", "")

    listaElementos.add(elemento1)
    listaElementos.add(elemento2)


    val adapter = NuevoElementoItemAdapter(listaElementos)
    val recycler = recyclerNuevoMaterial.findViewById<androidx.recyclerview.widget.RecyclerView>(com.example.slf_management.R.id.recyclerNuevoMaterial)
    val layoutManager= LinearLayoutManager(this@NuevoMaterialActivity, LinearLayoutManager.VERTICAL, false)
    recycler.layoutManager = layoutManager
    recycler.adapter = adapter
    }
}