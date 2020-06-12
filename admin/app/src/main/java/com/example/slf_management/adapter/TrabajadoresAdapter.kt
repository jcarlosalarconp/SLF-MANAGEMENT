package com.example.slf_management.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.slf_management.R
import com.example.slf_management.items.FichaItem
import com.example.slf_management.items.TrabajadorItem

class TrabajadoresAdapter(private var listaTrabajador: ArrayList<FichaItem>): RecyclerView.Adapter<TrabajadoresAdapter.SectionViewHolder>() {
    private var rvListener: SectionRecyclerViewListener?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        return SectionViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_ficha, parent, false))
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bind(listaTrabajador, position, rvListener)
    }

    override fun getItemCount(): Int {
        return listaTrabajador.size
    }

    fun setSectionRecyclerViewListener(listener: SectionRecyclerViewListener) {
        rvListener = listener
    }

    class SectionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val imagenTrabajador = itemView.findViewById<ImageView>(R.id.imagenFicha)
        private val nombreTrabajador = itemView.findViewById<TextView>(R.id.nombreFicha)

        fun bind(list: ArrayList<FichaItem>, position: Int, listener: SectionRecyclerViewListener?) {
            imagenTrabajador.setImageResource(list[position].imagenFicha)
            nombreTrabajador.text = list[position].nombreFicha

            itemView.setOnClickListener {
                listener?.onItemClick(position)

            }
        }
    }
    
    fun setlistaTrabajador(listTrabajador: ArrayList<FichaItem>){
        listaTrabajador = listTrabajador
        notifyDataSetChanged()
    }
    interface SectionRecyclerViewListener : SectionRecyclerViewFichaAdapter.SectionRecyclerViewListener {
        override fun onItemClick(itemPosition: Int)
    }
}