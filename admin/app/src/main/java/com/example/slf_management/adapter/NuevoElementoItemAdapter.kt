package com.example.slf_management.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.slf_management.R
import com.example.slf_management.items.NuevoElementoItem

class NuevoElementoItemAdapter(var arrayList: ArrayList<NuevoElementoItem>) :
        RecyclerView.Adapter<NuevoElementoItemAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_nuevoelemento, parent, false)
        return ItemHolder(itemHolder)

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val nuevoElementoItem: NuevoElementoItem = arrayList.get(position)

        holder.tituloNuevaInformacion.text = nuevoElementoItem.tituloNuevaInformacion
        holder.nuevaInformacion.text = nuevoElementoItem.nuevaInformacion

    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var tituloNuevaInformacion = itemView.findViewById<TextView>(R.id.tituloNuevaInformacion)
        var nuevaInformacion = itemView.findViewById<TextView>(R.id.nuevaInformacion)

    }

}