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
import com.example.slf_management.activitys.EventoActivity
import com.example.slf_management.adapter.EventosAdapter
import com.example.slf_management.items.EventoItem
import java.time.LocalDate

/**
 * A simple [Fragment] subclass.
 */
class EventosFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var gridLayoutManager: GridLayoutManager? = null


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_eventos, container, false)

        recyclerView = view!!.findViewById(R.id.recyclerEventos) as RecyclerView

        gridLayoutManager = GridLayoutManager(context, 1)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)

        /**
         * CREACIÓN DE LISTA E ITEMS (CAMBIAR POR BASE DE DATOS)
         */
        var listaEventos:ArrayList<EventoItem> = ArrayList()

        val evento1 = EventoItem(1, "Show de Funky", "Málaga", LocalDate.now())
        val evento2 = EventoItem(2, "Show de Wiwi", "Pizarra", LocalDate.now())
        val evento3 = EventoItem(3, "Show de Rickypin", "San Pedro", LocalDate.now())
        val evento4 = EventoItem(4, "Show de Candy", "Alhaurin el Grande", LocalDate.now())

        /**
         * INSERTANDO ITEMS EN LISTA
         */
        listaEventos.add(evento1)
        listaEventos.add(evento2)
        listaEventos.add(evento3)
        listaEventos.add(evento4)

        /**
         * SINCRONIZACIÓN CON EL ADAPTER
         */
        val adapter = EventosAdapter(inflater.context, listaEventos)

        /**
         * FUNCION ONCLICK QUE DIRIGE AL ACTIVITY EVENTO
         */
        adapter.setEventosListener(object : EventosAdapter.EventosListener {
            override fun onClick(position: Int) {
                val intent = Intent(context, EventoActivity::class.java)
                val bundle = Bundle()
                bundle.putInt("idEvento", listaEventos[position].idEvento)
                bundle.putString("servicioSolicitado", listaEventos[position].servicioSolicitado)
                bundle.putString("localidad", listaEventos[position].localidad)
                bundle.putString("fecha", listaEventos[position].fecha.toString())

                intent.putExtras(bundle)
                startActivity(intent)
            }

        })

        recyclerView.adapter = adapter

        return view
    }

}