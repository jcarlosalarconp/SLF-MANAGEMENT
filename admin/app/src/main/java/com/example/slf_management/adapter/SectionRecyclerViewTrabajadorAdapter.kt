package com.example.slf_management.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.slf_management.R
import com.example.slf_management.items.TrabajadorItem

class SectionRecyclerViewTrabajadorAdapter(private var listaTrabajadores: ArrayList<TrabajadorItem>): RecyclerView.Adapter<SectionRecyclerViewTrabajadorAdapter.SectionViewHolder>() {
    private var rvListener: SectionRecyclerViewListener?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        return SectionViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_trabajador, parent, false))
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bind(listaTrabajadores, position, rvListener)
    }

    override fun getItemCount(): Int {
        return listaTrabajadores.size
    }

    fun setSectionRecyclerViewListener(listener: SectionRecyclerViewListener) {
        rvListener = listener
    }

    class SectionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val imagenTrabajador = itemView.findViewById<ImageView>(R.id.imagenTrabajador)
        private val nombreTrabajador = itemView.findViewById<TextView>(R.id.nombreTrabajador)
        private val botonCancelar = itemView.findViewById<ImageView>(R.id.buttonCancelTrabajador)

        fun bind(list: ArrayList<TrabajadorItem>, position: Int, listener: SectionRecyclerViewListener?) {
            imagenTrabajador.setImageResource(list[position].imagenTrabajador)
            nombreTrabajador.text = list[position].nombreTrabajador
            botonCancelar.setOnClickListener{
                listener?.onDeleteClick(position)
            }
            itemView.setOnClickListener {
                listener?.onItemClick(position)
            }
        }
    }
    //FUNCION QUE DUVUELVE LA LISTA TRABAJADORES ACTUALIZADA
    fun setListaTrabajadores(listTrabajadores: ArrayList<TrabajadorItem>){
        listaTrabajadores = listTrabajadores
        notifyDataSetChanged()
    }

    interface SectionRecyclerViewListener {
        fun onItemClick(itemPosition: Int)
        fun onDeleteClick(itemPosition: Int)
    }

}