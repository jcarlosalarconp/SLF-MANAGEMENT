package com.example.slf_management.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView

import com.example.slf_management.R
import com.example.slf_management.adapter.MaterialAdapter
import com.example.slf_management.items.MaterialItem

/**
 * A simple [Fragment] subclass.
 */
class MaterialFragment : Fragment() {
    private lateinit var listView: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_material, container, false)
        listView = view!!.findViewById(R.id.listViewMateriales) as ListView

        val material = MaterialItem("Altavoz", true, R.drawable.material_icon)
        val material2 = MaterialItem("Microfono", false, R.drawable.material_icon)

        val listaMateriales = listOf(material, material2)

        val adapter = MaterialAdapter(inflater.context, listaMateriales)

        listView.adapter = adapter

        return view
    }

}
 