package com.example.slf_management.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.slf_management.R
import com.example.slf_management.items.PersonalInfoItem

class InfoPersonalAdapter(var context: Context, var arrayList: ArrayList<PersonalInfoItem>) :
        RecyclerView.Adapter<InfoPersonalAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_infopersonal, parent, false)
        return ItemHolder(itemHolder)

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val personalInfoItem: PersonalInfoItem = arrayList.get(position)

        holder.tituloInfoPersonal.text = personalInfoItem.tituloInfo
        holder.informacionInfoPersonal.text = personalInfoItem.informacionInfo

    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var tituloInfoPersonal = itemView.findViewById<TextView>(R.id.tituloInfoPersonal)
        var informacionInfoPersonal = itemView.findViewById<TextView>(R.id.informacionInfoPersonal)

    }

}