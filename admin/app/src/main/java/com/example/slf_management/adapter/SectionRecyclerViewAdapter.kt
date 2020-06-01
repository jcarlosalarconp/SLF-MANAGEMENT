package com.example.slf_management.adapter

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.slf_management.R
import com.example.slf_management.items.Comentario

class SectionRecyclerViewAdapter(private val items: ArrayList<ClipData.Item>): RecyclerView.Adapter<SectionRecyclerViewAdapter.SectionViewHolder>() {
    private lateinit var rvListener: SectionRecyclerViewListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        return SectionViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_child, parent, false))
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bind(items, position, rvListener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setSectionRecyclerViewListener(listener: SectionRecyclerViewListener) {
        rvListener = listener
    }

    class SectionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val nombre = itemView.findViewById<TextView>(R.id.nombreComentario)
        private val comentario = itemView.findViewById<TextView>(R.id.comentarioComentario)
        private val fecha = itemView.findViewById<TextView>(R.id.fechaComentario)

        fun bind(list: ArrayList<Comentario>, position: Int, listener: SectionRecyclerViewListener) {
            nombre.text = list[position].nombre
            comentario.text = list[position].comentario
            fecha.text = list[position].fecha.toString()

            itemView.setOnClickListener {
                listener.onItemClick(position)
            }
        }
    }

    interface SectionRecyclerViewListener {
        fun onItemClick(itemPosition: Int)
    }
}