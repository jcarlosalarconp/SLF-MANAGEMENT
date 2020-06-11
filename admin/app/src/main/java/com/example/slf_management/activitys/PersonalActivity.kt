package com.example.slf_management.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.slf_management.R
import com.example.slf_management.adapter.ListaItemAdapter
import com.example.slf_management.adapter.SectionRecyclerViewComentariosAdapter
import com.example.slf_management.adapter.SectionRecyclerViewListaItemAdapter
import com.example.slf_management.items.ListaItem
import kotlinx.android.synthetic.main.activity_evento.*
import kotlinx.android.synthetic.main.activity_material.*
import kotlinx.android.synthetic.main.activity_personal.*
import java.util.ArrayList

class PersonalActivity : AppCompatActivity() {

    private val nombrePersonalActivity by lazy { findViewById<TextView>(R.id.nombrePersonalActivity) }
    private val imagenPersonalActivity by lazy { findViewById<ImageView>(R.id.imagenPersonalActivity) }
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal)
        setSupportActionBar(findViewById(R.id.toolbarPersonal))

        intent.extras?.let {
            val nombrePersonal = it.getString("nombrePersonal")
            val imagenPersonal = it.getInt("imagenPersonal")
            nombrePersonalActivity.text = nombrePersonal
            imagenPersonalActivity.setImageResource(imagenPersonal)
        }



        var listaPersonalInfo:ArrayList<ListaItem> = arrayListOf()

        val evento1 = ListaItem("Nombre", "Juan Carlos")
        val evento2 = ListaItem("Teléfono", "355148524")
        val evento3 = ListaItem("DNI", "26351478P")
        val evento4 = ListaItem("Dirección", "c/ Gondola 2")
        val evento5 = ListaItem("Tlf. contacto externo", "652147884")
        val evento6 = ListaItem("Nº Seguridad Social", "3549842")

        listaPersonalInfo.add(evento1)
        listaPersonalInfo.add(evento2)
        listaPersonalInfo.add(evento3)
        listaPersonalInfo.add(evento4)
        listaPersonalInfo.add(evento5)
        listaPersonalInfo.add(evento6)

        val adapterPersonalInfo = ListaItemAdapter(listaPersonalInfo)
        val recyclerPersonalInfo = recyclerPersonalInfo.findViewById<RecyclerView>(R.id.recyclerPersonalInfo)
        val layoutManagerPersonalInfo = LinearLayoutManager(this@PersonalActivity, LinearLayoutManager.VERTICAL, false)
        recyclerPersonalInfo.layoutManager = layoutManagerPersonalInfo
        recyclerPersonalInfo.adapter = adapterPersonalInfo

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.editProfile -> {}
        }
        return true
    }
}
