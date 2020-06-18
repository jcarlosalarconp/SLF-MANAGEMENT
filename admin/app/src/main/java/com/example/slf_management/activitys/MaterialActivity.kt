package com.example.slf_management.activitys

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.slf_management.R
import com.example.slf_management.adapter.SectionRecyclerViewComentariosAdapter
import com.example.slf_management.adapter.SectionRecyclerViewEventosAdapter
import com.example.slf_management.items.Evento
import com.example.slf_management.items.ListaComentarios
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_material.*
import java.time.LocalDate
import kotlin.collections.ArrayList

class MaterialActivity : AppCompatActivity() {

    private val nombreMaterialActivity by lazy { findViewById<TextView>(R.id.nombreMaterialActivity) }
    private val imagenMaterialActivity by lazy { findViewById<ImageView>(R.id.imagenMaterialActivity) }
    private var mostrarComentarios = true
    private var mostrarEventos = true
    private val db by lazy { FirebaseFirestore.getInstance()}
    private var listaComentarios = ListaComentarios(arrayListOf())
    private var adapterComentarios = SectionRecyclerViewComentariosAdapter(listaComentarios.listaComentario)

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material)
        intent.extras?.let {
            val nombreMaterial = it.getString("nombreMaterial")
            val imagenMaterial = it.getInt("imagenMaterial")
            nombreMaterialActivity.text = nombreMaterial
            imagenMaterialActivity.setImageResource(imagenMaterial)
        }

        title = "Material"

        /**
         * LISTA COMENTARIOS
         */
        /**
         * RECOGE DE BASE DE DATOS LOS COMENTARIOS
         */
        db.collection("slf-management").document("comentarios").get().addOnCompleteListener{ task ->
            if (task.isSuccessful){
                listaComentarios = task.result!!.toObject(ListaComentarios::class.java)!!
                adapterComentarios.setListaComentario(listaComentarios.listaComentario)
            }else{
                Toast.makeText(this@MaterialActivity, task.exception.toString(), Toast.LENGTH_LONG).show()

            }
        }

        /**
         * SINCRONIZACIÓN CON LOS ADAPTERS
         */
        val recyclerMenuComentarios = listaComentario.findViewById<RecyclerView>(R.id.recyclerMenu)
        val layoutManagerComentarios = LinearLayoutManager(this@MaterialActivity, LinearLayoutManager.VERTICAL, false)
        recyclerMenuComentarios.layoutManager = layoutManagerComentarios
        recyclerMenuComentarios.adapter = adapterComentarios
        recyclerMenuComentarios.visibility = View.VISIBLE
        listaComentario.setOnClickListener(object : View.OnClickListener{

            /**
             * FUNCIÓN ONCLIC PARA OCULTAR/MOSTRAR LISTA
             */
            override fun onClick(v: View?) {

                if (!mostrarComentarios) {
                    recyclerMenuComentarios.visibility = View.VISIBLE
                    mostrarComentarios = true
                }
                else {
                    recyclerMenuComentarios.visibility = View.GONE
                    mostrarComentarios = false
                }
            }
        })

        /**
         * ESTABLECIENDO TITULO
         */
        val textoComentario = listaComentario.findViewById<TextView>(R.id.tituloMenu)
        textoComentario.text = "Comentarios"

        /**
         * LISTA EVENTOS
         */
        /**
         * CREACIÓN DE LISTA E ITEMS (CAMBIAR POR BASE DE DATOS)
         */
        val listaEventos : ArrayList<Evento> = arrayListOf()
        val evento1 = Evento(1, "Show de Funky", "Málaga", LocalDate.now())
        val evento2 = Evento(2, "Show de Wiwi", "Pizarra", LocalDate.now())
        val evento3 = Evento(3, "Show de Rickypin", "San Pedro", LocalDate.now())
        val evento4 = Evento(4, "Show de Candy", "Alhaurin el Grande", LocalDate.now())

        /**
         * INSERTANDO ITEMS EN LISTA
         */
        listaEventos.add(evento1)
        listaEventos.add(evento2)
        listaEventos.add(evento3)
        listaEventos.add(evento4)

        /**
         * SINCRONIZACIÓN CON LOS ADAPTERS
         */
        val adapter = SectionRecyclerViewEventosAdapter(listaEventos)
        val recyclerMenu = listaEvento.findViewById<RecyclerView>(R.id.recyclerMenu)
        val layoutManager = LinearLayoutManager(this@MaterialActivity, LinearLayoutManager.VERTICAL, false)
        recyclerMenu.layoutManager = layoutManager
        recyclerMenu.adapter = adapter
        recyclerMenu.visibility = View.VISIBLE

        /**
         * FUNCIÓN ONCLIC PARA OCULTAR/MOSTRAR LISTA
         */
        listaEvento.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

                if (!mostrarEventos) {
                    recyclerMenu.visibility = View.VISIBLE
                    mostrarEventos = true
                }
                else {
                    recyclerMenu.visibility = View.GONE
                    mostrarEventos = false
                }
            }
        })
        /**
         * ESTABLECIENDO TITULO
         */
        val textoEvento = listaEvento.findViewById<TextView>(R.id.tituloMenu)
        textoEvento.text = "Eventos"

        /**
         * FUNCIÓN ONCLICK QUE REDIRIGE AL ACTIVITYEVENTO
         */
        adapter.setSectionRecyclerViewListener(object :SectionRecyclerViewEventosAdapter.SectionRecyclerViewListener{
            override fun onItemClick(itemPosition: Int) {
                val intent = Intent(this@MaterialActivity, EventoActivity::class.java)
                startActivity(intent)
            }
        })

        /**
         * IMAGEN
         */
        val imagen = findViewById<ImageView>(R.id.imagenMaterialActivity)
        imagen.setOnClickListener{
            Toast.makeText(this, "Hacer foto", Toast.LENGTH_SHORT).show()
        }
    }

}