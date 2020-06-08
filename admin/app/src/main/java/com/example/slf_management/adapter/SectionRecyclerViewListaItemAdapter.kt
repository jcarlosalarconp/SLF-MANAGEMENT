package com.example.slf_management.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.slf_management.R
import com.example.slf_management.items.ListaItem

class SectionRecyclerViewListaItemAdapter(private val listaItems: ArrayList<ListaItem>): RecyclerView.Adapter<SectionRecyclerViewListaItemAdapter.SectionViewHolder>() {
    private var rvListener: SectionRecyclerViewListener?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        return SectionViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false))
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bind(listaItems, position, rvListener)
    }

    override fun getItemCount(): Int {
        return listaItems.size
    }

    fun setSectionRecyclerViewListener(listener: SectionRecyclerViewListener) {
        rvListener = listener
    }

    class SectionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val tituloItem = itemView.findViewById<TextView>(R.id.tituloItemLista)
        private val informacionItem = itemView.findViewById<TextView>(R.id.informacionItemLista)

        fun bind(list: ArrayList<ListaItem>, position: Int, listener: SectionRecyclerViewListener?) {
            tituloItem.text = list[position].tituloItemLista
            informacionItem.text = list[position].informacionItemLista

            itemView.setOnClickListener {
                listener?.onItemClick(position)
            }
        }
    }

    interface SectionRecyclerViewListener {
        fun onItemClick(itemPosition: Int)
    }
}