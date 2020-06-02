package com.example.slf_management.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.slf_management.R
import com.example.slf_management.items.Evento

class SectionRecyclerViewEventosAdapter(private val eventos: ArrayList<Evento>): RecyclerView.Adapter<SectionRecyclerViewEventosAdapter.SectionViewHolder>() {
    private var rvListener: SectionRecyclerViewListener?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        return SectionViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_evento, parent, false))
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bind(eventos, position, rvListener)
    }

    override fun getItemCount(): Int {
        return eventos.size
    }

    fun setSectionRecyclerViewListener(listener: SectionRecyclerViewListener) {
        rvListener = listener
    }

    class SectionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val id = itemView.findViewById<TextView>(R.id.idEvento)
        private val servicioSolicitado = itemView.findViewById<TextView>(R.id.servicioSolicitadoEvento)
        private val fecha = itemView.findViewById<TextView>(R.id.fechaEvento)
        private val localidad = itemView.findViewById<TextView>(R.id.localidadEvento)


        fun bind(list: ArrayList<Evento>, position: Int, listener: SectionRecyclerViewListener?) {
            id.text = list[position].id.toString()
            servicioSolicitado.text = list[position].servicioSolicitado
            fecha.text = list[position].fecha.toString()
            localidad.text = list[position].localidad

            itemView.setOnClickListener {
                listener?.onItemClick(position)
            }
        }
    }

    interface SectionRecyclerViewListener {
        fun onItemClick(itemPosition: Int)
    }
}