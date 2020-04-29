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
import com.example.slf_management.items.MaterialItem

class MaterialAdapter(var context: Context, var arrayList: ArrayList<MaterialItem>) :
        RecyclerView.Adapter<MaterialAdapter.ItemHolder>() {

    private lateinit var mListener: MaterialListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_material, parent, false)
        return ItemHolder(itemHolder)

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    fun setMaterialListener(listener: MaterialListener){
        mListener = listener
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val materialItem: MaterialItem = arrayList.get(position)

        holder.imagen.setImageResource(materialItem.imagenMaterial!!)
        holder.nombre.text = materialItem.nombreMaterial
        holder.disponibilidad.text = materialItem.disponibilidadMaterial.toString()

        holder.itemView.setOnClickListener() {
            mListener.onClick(position)
        }
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var imagen = itemView.findViewById<ImageView>(R.id.imagenMaterial)
        var nombre = itemView.findViewById<TextView>(R.id.nombreMaterial)
        var disponibilidad = itemView.findViewById<TextView>(R.id.disponibilidadMaterial)

    }

    interface MaterialListener{
        fun onClick(position: Int)
    }

}