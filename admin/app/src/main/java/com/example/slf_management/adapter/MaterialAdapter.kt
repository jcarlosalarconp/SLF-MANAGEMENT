package com.example.slf_management.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.slf_management.R
import com.example.slf_management.items.MaterialItem
import kotlinx.android.synthetic.main.item_material.view.*

class MaterialAdapter(private val mContext: Context, private val listaMateriales: List<MaterialItem>) : ArrayAdapter<MaterialItem>(mContext, 0, listaMateriales) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_material, parent, false)

        val material = listaMateriales[position]

        layout.nombre.text = material.nombre
        layout.disponibilidad.text = material.disponibilidad.toString()
        layout.imageView.setImageResource(material.imagen)

        return layout
    }
}