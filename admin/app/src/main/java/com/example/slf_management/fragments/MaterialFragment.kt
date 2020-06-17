package com.example.slf_management.fragments


import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.slf_management.R
import com.example.slf_management.activitys.MaterialActivity
import com.example.slf_management.adapter.MaterialAdapter
import com.example.slf_management.items.ComentarioItem
import com.example.slf_management.items.MaterialItem
import java.time.LocalDate

/**
 * A simple [Fragment] subclass.
 */
class MaterialFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var gridLayoutManager: GridLayoutManager? = null


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_material, container, false)

        recyclerView = view!!.findViewById(R.id.recyclerMaterial) as RecyclerView

        gridLayoutManager = GridLayoutManager(context, 3)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        //CREACIÓN DE LISTA E ITEMS (CAMBIAR POR BASE DE DATOS)
        var listaComentarios:ArrayList<ComentarioItem> = ArrayList()

        var listaMaterial:ArrayList<MaterialItem> = ArrayList()

        val material = MaterialItem(1,"Altavoz Behringer Pequeño","Sonido", true, R.drawable.material_icon, listaComentarios)
        val material2 = MaterialItem(2,"Altavoz de Bateria","Sonido", true, R.drawable.material_icon, listaComentarios)
        val material3 = MaterialItem(3,"Microfono de diadema","Sonido", false, R.drawable.material_icon, listaComentarios)
        val material4 = MaterialItem(4,"Microfono de mano","Sonido", true, R.drawable.material_icon, listaComentarios)
        val material5 = MaterialItem(5,"Maleta de sonido","Sonido", false, R.drawable.material_icon, listaComentarios)
        val material6 = MaterialItem(6,"Caja de animación","Animacion", false, R.drawable.material_icon, listaComentarios)
        val material7 = MaterialItem(7,"Traje de Spider-Man","Vestuario", true, R.drawable.material_icon, listaComentarios)
        val material8 = MaterialItem(8,"Pie de piano","Montaje", false, R.drawable.material_icon, listaComentarios)

        //INSERTANDO ITEMS EN LISTA
        listaMaterial.add(material)
        listaMaterial.add(material2)
        listaMaterial.add(material3)
        listaMaterial.add(material4)
        listaMaterial.add(material5)
        listaMaterial.add(material6)
        listaMaterial.add(material7)
        listaMaterial.add(material8)

        //SINCRONIZACIÓN CON EL ADAPTER
        val adapter = MaterialAdapter(inflater.context, listaMaterial)

        //FUNCION ONCLICK QUE DIRIGE AL ACTIVITY MATERIAL
        adapter.setMaterialListener(object : MaterialAdapter.MaterialListener {
            override fun onClick(position: Int) {
                val intent = Intent(context, MaterialActivity::class.java)
                val bundle = Bundle()
                bundle.putString("nombreMaterial", listaMaterial[position].nombreMaterial)
                bundle.putInt("imagenMaterial", listaMaterial[position].imagenMaterial)
                intent.putExtras(bundle)
                startActivity(intent)
            }

        })

        recyclerView.adapter = adapter

        return view
    }

}