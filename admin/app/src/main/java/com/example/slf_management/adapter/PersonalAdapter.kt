package com.example.slf_management.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.slf_management.R
import com.example.slf_management.items.PersonalItem

class PersonalAdapter(var context: Context, var arrayList: ArrayList<PersonalItem>) :
        RecyclerView.Adapter<PersonalAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_personal, parent, false)
        return ItemHolder(itemHolder)

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val personalItem: PersonalItem = arrayList.get(position)

        holder.imagen.setImageResource(personalItem.imagenPersonal!!)
        holder.nombre.text = personalItem.nombrePersonal

        holder.nombre.setOnClickListener {
            Toast.makeText(context, personalItem.nombrePersonal, Toast.LENGTH_LONG).show()
        }
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var imagen = itemView.findViewById<ImageView>(R.id.imagenPersonal)
        var nombre = itemView.findViewById<TextView>(R.id.nombrePersonal)

    }


}