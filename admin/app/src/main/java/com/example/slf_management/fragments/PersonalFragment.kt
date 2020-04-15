package com.example.slf_management.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.slf_management.R
import com.example.slf_management.adapter.PersonalAdapter
import com.example.slf_management.items.PersonalItem

/**
 * A simple [Fragment] subclass.
 */
class PersonalFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_personal, container, false)
        recyclerView = view!!.findViewById(R.id.recyclerViewPersonal) as RecyclerView

        val personal = PersonalItem("Juan Carlos", R.drawable.personal_icon)
        val personal2 = PersonalItem("Javier", R.drawable.personal_icon)

        val listaPersonal = listOf(personal, personal2)

        val adapter = PersonalAdapter(inflater.context, listaPersonal)

        recyclerView.adapter = adapter

        return view
    }

}
