package com.example.slf_management.fragments


import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.slf_management.R
import com.example.slf_management.activitys.PersonalActivity
import com.example.slf_management.adapter.EventosAdapter
import com.example.slf_management.adapter.PersonalAdapter
import com.example.slf_management.items.EventoItem
import com.example.slf_management.items.PersonalItem
import java.time.LocalDate

/**
 * A simple [Fragment] subclass.
 */
class PersonalFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var gridLayoutManager: GridLayoutManager? = null


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_personal, container, false)

        recyclerView = view!!.findViewById(R.id.recyclerPersonal) as RecyclerView

        gridLayoutManager = GridLayoutManager(context, 2)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)

        /**
         * CREACIÓN DE LISTA E ITEMS (CAMBIAR POR BASE DE DATOS)
         */
        var listaPersonal:ArrayList<PersonalItem> = ArrayList()

        val personal = PersonalItem("Juan Carlos", R.drawable.personal_icon)
        val personal2 = PersonalItem("Javier", R.drawable.personal_icon)
        val personal3 = PersonalItem("Juan Carlos", R.drawable.personal_icon)
        val personal4 = PersonalItem("Javier", R.drawable.personal_icon)

        /**
         * INSERTANDO ITEMS EN LISTA
         */
        listaPersonal.add(personal)
        listaPersonal.add(personal2)
        listaPersonal.add(personal3)
        listaPersonal.add(personal4)

        /**
         * SINCRONIZACIÓN CON EL ADAPTER
         */
        val adapter = PersonalAdapter(inflater.context, listaPersonal)

        /**
         * FUNCION ONCLICK QUE DIRIGE A ACTIVIRY PERSONAL
         */
        adapter.setPersonalListener(object : PersonalAdapter.PersonalListener {
            override fun onClick(position: Int) {
                val intent = Intent(context, PersonalActivity::class.java)
                val bundle = Bundle()
                bundle.putString("nombrePersonal", listaPersonal[position].nombrePersonal)
                bundle.putInt("imagenPersonal", listaPersonal[position].imagenPersonal)
                intent.putExtras(bundle)
                startActivity(intent)
            }

        })

        recyclerView.adapter = adapter

        return view
    }

}