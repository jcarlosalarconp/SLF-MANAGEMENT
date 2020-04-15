package com.example.slf_management.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.slf_management.R
import com.example.slf_management.items.EventoItem
import kotlinx.android.synthetic.main.item_evento.view.*

class EventosAdapter(private val mContext: Context, private val listaEventos: List<EventoItem>) : ArrayAdapter<EventoItem>(mContext, 0, listaEventos) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_evento, parent, false)

        val evento = listaEventos[position]

        layout.idEvento.text = evento.idEvento.toString()
        layout.servicioSolicitado.text = evento.servicioSolicitado
        layout.localidad.text = evento.fecha.toString()

        return layout
    }
}