package com.example.slf_management.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.slf_management.R
import com.example.slf_management.items.FichaItem

class SectionRecyclerViewFichaAdapter(private val listaFicha: ArrayList<FichaItem>): RecyclerView.Adapter<SectionRecyclerViewFichaAdapter.SectionViewHolder>() {
    private var rvListener: SectionRecyclerViewListener?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        return SectionViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_ficha, parent, false))
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bind(listaFicha, position, rvListener)
    }

    override fun getItemCount(): Int {
        return listaFicha.size
    }

    fun setSectionRecyclerViewListener(listener: TrabajadoresAdapter.SectionRecyclerViewListener) {
        rvListener = listener
    }

    class SectionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val imagenFicha = itemView.findViewById<ImageView>(R.id.imagenFicha)
        private val nombreFicha = itemView.findViewById<TextView>(R.id.nombreFicha)

        fun bind(list: ArrayList<FichaItem>, position: Int, listener: SectionRecyclerViewListener?) {
            imagenFicha.setImageResource(list[position].imagenFicha)
            nombreFicha.text = list[position].nombreFicha

            itemView.setOnClickListener {
                listener?.onItemClick(position)
            }
        }
    }

    interface SectionRecyclerViewListener {
        fun onItemClick(itemPosition: Int)
    }
}