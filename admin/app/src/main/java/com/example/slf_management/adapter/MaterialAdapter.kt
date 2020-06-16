package com.example.slf_management.adapter


import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
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

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val materialItem: MaterialItem = arrayList.get(position)

        holder.imagen.setImageResource(materialItem.imagenMaterial!!)
        holder.nombre.text = materialItem.nombreMaterial

        if(materialItem.disponibilidadMaterial){
            holder.fondo.setCardBackgroundColor(R.color.colorPrimary)
        }else{
            holder.fondo.setCardBackgroundColor(R.color.red_active)

        }

        holder.itemView.setOnClickListener() {
            mListener.onClick(position)
        }
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var imagen = itemView.findViewById<ImageView>(R.id.imagenMaterial)
        var nombre = itemView.findViewById<TextView>(R.id.nombreMaterial)
        var fondo = itemView.findViewById<CardView>(R.id.cardViewMaterialItem)
    }

    interface MaterialListener{
        fun onClick(position: Int)
    }

    fun setListaMateriales(listaMateriales: ArrayList<MaterialItem>){
        arrayList = listaMateriales
        notifyDataSetChanged()
    }
}