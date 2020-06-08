package com.example.slf_management.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.slf_management.R
import com.example.slf_management.adapter.ListaItemAdapter
import com.example.slf_management.items.ListaItem
import java.util.ArrayList

class PersonalActivity : AppCompatActivity() {

    private val nombrePersonalActivity by lazy { findViewById<TextView>(R.id.nombrePersonalActivity) }
    private val imagenPersonalActivity by lazy { findViewById<ImageView>(R.id.imagenPersonalActivity) }
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal)
        intent.extras?.let {
            val nombrePersonal = it.getString("nombrePersonal")
            val imagenPersonal = it.getInt("imagenPersonal")
            nombrePersonalActivity.text = nombrePersonal
            imagenPersonalActivity.setImageResource(imagenPersonal)
        }

        recyclerView = findViewById(R.id.recyclerPersonalInfo)
        val listaInfo : ArrayList<ListaItem> = ArrayList()
        val personalInfo = ListaItem("Nombre", "Juan Carlos")
        listaInfo.add(personalInfo)
        val adapter = ListaItemAdapter(this, listaInfo)
        val recyclerInfo = findViewById<RecyclerView>(R.id.recyclerPersonalInfo)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerInfo.layoutManager
        recyclerInfo.adapter = adapter
    }
}
