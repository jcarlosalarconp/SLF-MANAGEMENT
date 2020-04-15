package com.example.slf_management.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.slf_management.R
import com.example.slf_management.items.PersonalItem
import kotlinx.android.synthetic.main.item_personal.view.*

class PersonalAdapter(private val mContext: Context, private val listaPersonal: List<PersonalItem>) : ArrayAdapter<PersonalItem>(mContext, 0, listaPersonal) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_personal, parent, false)

        val personal = listaPersonal[position]

        layout.nombre.text = personal.nombre
        layout.imagen.setImageResource(personal.imagen)

        return layout
    }
}