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

import com.example.slf_management.R
import com.example.slf_management.activitys.EventoActivity
import com.example.slf_management.adapter.EventosAdapter
import com.example.slf_management.items.EventoItem
import java.time.LocalDate

/**
 * A simple [Fragment] subclass.
 */
class EventosFragment : Fragment() {
    private lateinit var listView: ListView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_eventos, container, false)
        listView = view!!.findViewById(R.id.listViewEventos) as ListView

        val evento = EventoItem(1, "Show de Funky", "Málaga", LocalDate.now())
        val evento2 = EventoItem(2, "Show de Wiwi", "Pizarra", LocalDate.now())

        val listaEventos = listOf(evento, evento2)

        val adapter = EventosAdapter(inflater.context, listaEventos)

        adapter.setEventosListener(object : EventosAdapter.EventosListener {
            override fun onClick(position: Int) {
                val intent = Intent(context, EventoActivity::class.java)
                val bundle = Bundle()
                //bundle.putString("nombreEvento", listaEventos[position].)
                //bundle.putString("imagenEvento", listaEventos[position].imagenEvento)
                intent.putExtras(bundle)
                startActivity(intent)
            }

        })

        listView.adapter = adapter

        return view
    }

}
