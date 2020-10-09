package com.example.slf_management.fragments


import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.slf_management.R
import com.example.slf_management.activitys.MaterialActivity
import com.example.slf_management.adapter.MaterialAdapter
import com.example.slf_management.items.ComentarioItem
import com.example.slf_management.items.ListaMateriales
import com.example.slf_management.items.MaterialItem
import com.google.firebase.firestore.FirebaseFirestore

/**
 * A simple [Fragment] subclass.
 */
class MaterialFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var gridLayoutManager: GridLayoutManager? = null
    private val db by lazy { FirebaseFirestore.getInstance()}
    private var listaMateriales = ListaMateriales(arrayListOf())
    private var adapterMateriales = MaterialAdapter(listaMateriales.listaMaterial ,listaMateriales.listaMaterial)
    private var listaMaterial:ArrayList<MaterialItem> = ArrayList()


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_material, container, false)

        recyclerView = view!!.findViewById(R.id.recyclerMaterial) as RecyclerView

        gridLayoutManager = GridLayoutManager(context, 3)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)

        /**
         * RECOGE DE BASE DE DATOS TODOS LOS MATERIALES Y LOS METE EN UNA LISTA
         */
        db.collection("slf-management").document("material").get().addOnCompleteListener{ task ->
            if (task.isSuccessful){
                listaMateriales = task.result!!.toObject(ListaMateriales::class.java)!!
                adapterMateriales.setListaMateriales(listaMateriales.listaMaterial)
            }else{
                Toast.makeText(activity, task.exception.toString(), Toast.LENGTH_LONG).show()
            }
        }


        /**
         * FUNCION ONCLICK QUE DIRIGE AL ACTIVITY MATERIAL
         */
        adapterMateriales.setMaterialListener(object : MaterialAdapter.MaterialListener {
            override fun onClick(position: Int) {
                val intent = Intent(context, MaterialActivity::class.java)
                val bundle = Bundle()
                intent.putExtras(bundle)
                startActivity(intent)
            }

        })

        recyclerView.adapter = adapterMateriales

        return view
    }

}