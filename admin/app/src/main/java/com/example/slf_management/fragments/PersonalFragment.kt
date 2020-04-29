package com.example.slf_management.fragments


import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.slf_management.R
import com.example.slf_management.adapter.EventosAdapter
import com.example.slf_management.adapter.PersonalAdapter
import com.example.slf_management.items.EventoItem
import com.example.slf_management.items.PersonalItem
import java.time.LocalDate

/**
 * A simple [Fragment] subclass.
 */
class PersonalFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var gridLayoutManager: GridLayoutManager? = null


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_personal, container, false)

        recyclerView = view!!.findViewById(R.id.myRecycler) as RecyclerView

        gridLayoutManager = GridLayoutManager(context, 3)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)

        var listaPersonal:ArrayList<PersonalItem> = ArrayList()

        val personal = PersonalItem("Juan Carlos", R.drawable.personal_icon)
        val personal2 = PersonalItem("Javier", R.drawable.personal_icon)
        val personal3 = PersonalItem("Juan Carlos", R.drawable.personal_icon)
        val personal4 = PersonalItem("Javier", R.drawable.personal_icon)

        listaPersonal.add(personal)
        listaPersonal.add(personal2)
        listaPersonal.add(personal3)
        listaPersonal.add(personal4)

        val adapter = PersonalAdapter(inflater.context, listaPersonal)
        recyclerView.adapter = adapter

        return view
    }

}