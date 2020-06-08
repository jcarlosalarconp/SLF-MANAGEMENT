package com.example.slf_management.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.slf_management.R
import com.example.slf_management.items.ListaItem

class ListaItemAdapter(var context: Context, var arrayList: ArrayList<ListaItem>) :
        RecyclerView.Adapter<ListaItemAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        return ItemHolder(itemHolder)

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val personalInfoItem: ListaItem = arrayList.get(position)

        holder.tituloInfoPersonal.text = personalInfoItem.tituloItemLista
        holder.informacionInfoPersonal.text = personalInfoItem.informacionItemLista

    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var tituloInfoPersonal = itemView.findViewById<TextView>(R.id.tituloItemLista)
        var informacionInfoPersonal = itemView.findViewById<TextView>(R.id.informacionItemLista)

    }

}