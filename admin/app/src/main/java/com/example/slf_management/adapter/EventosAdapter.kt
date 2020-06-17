package com.example.slf_management.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.slf_management.R
import com.example.slf_management.items.EventoItem

/**
 * ADAPTER DEL ITEM EVENTO
 */
class EventosAdapter(var context: Context, var arrayList: ArrayList<EventoItem>) :
        RecyclerView.Adapter<EventosAdapter.ItemHolder>() {

    private lateinit var mListener: EventosListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_evento, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    fun setEventosListener(listener: EventosListener){
        mListener = listener
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val eventoItem: EventoItem = arrayList.get(position)

        holder.idEvento.text = eventoItem.idEvento.toString()
        holder.servicioSolicitado.text = eventoItem.servicioSolicitado
        holder.localidad.text = eventoItem.localidad
        holder.fecha.text = eventoItem.fecha.toString()

        holder.itemView.setOnClickListener() {
            mListener.onClick(position)
        }
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var idEvento = itemView.findViewById<TextView>(R.id.idEvento)
        var servicioSolicitado = itemView.findViewById<TextView>(R.id.servicioSolicitadoEvento)
        var localidad = itemView.findViewById<TextView>(R.id.localidadEvento)
        var fecha = itemView.findViewById<TextView>(R.id.fechaEvento)


    }

    interface EventosListener{
        fun onClick(position: Int)
    }

}