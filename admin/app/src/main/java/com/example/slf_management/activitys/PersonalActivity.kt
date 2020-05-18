package com.example.slf_management.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.example.slf_management.R
import com.example.slf_management.adapter.EventosAdapter
import com.example.slf_management.adapter.PersonalInfoAdapter
import com.example.slf_management.items.ComentarioItem
import com.example.slf_management.items.PersonalInfoItem
import java.util.ArrayList

class PersonalActivity : AppCompatActivity() {

    private val nombrePersonalActivity by lazy { findViewById<TextView>(R.id.nombrePersonalActivity) }
    private val imagenPersonalActivity by lazy { findViewById<ImageView>(R.id.imagenPersonalActivity) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal)
        intent.extras?.let {
            val nombrePersonal = it.getString("nombrePersonal")
            val imagenPersonal = it.getInt("imagenPersonal")
            nombrePersonalActivity.text = nombrePersonal
            imagenPersonalActivity.setImageResource(imagenPersonal)
        }
        val listView: ListView = findViewById(R.id.listViewPersonal)

        val personalInfo = PersonalInfoItem("Nombre", "Juan Carlos")
        val listaInfo : ArrayList<PersonalInfoItem> = ArrayList()
        listaInfo.add(personalInfo)
        val adapter = PersonalInfoAdapter(this, listaInfo)
        listView.adapter = adapter
    }
}
