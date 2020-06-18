package com.example.slf_management.activitys

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.slf_management.R
import com.example.slf_management.adapter.SectionRecyclerViewFichaAdapter
import com.example.slf_management.adapter.SectionRecyclerViewListaItemAdapter
import com.example.slf_management.adapter.SectionRecyclerViewTrabajadorAdapter
import com.example.slf_management.items.FichaItem
import com.example.slf_management.items.ListaItem
import com.example.slf_management.items.TrabajadorItem
import kotlinx.android.synthetic.main.activity_evento.*
import java.time.LocalDate

class EventoActivity : AppCompatActivity() {

    private var mostrarDatosGenerales = true
    private var mostrarInformacionDeLaFiesta = true
    private var mostrarInformacionDelCliente = true
    private var mostrarTrabajadores = true
    private var mostrarFichas = true

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_evento)

        /**
         * LISTA DATOS GENERALES
         */
        /**
         * CREACIÓN DE LISTA E ITEMS (CAMBIAR POR BASE DE DATOS)
         */
        val listaDatosGenereales: ArrayList<ListaItem> = arrayListOf()
        val item = ListaItem("Servicio", "Show de Funky")
        val item2 = ListaItem("Precio", "150€")
        val item3 = ListaItem("Fecha", LocalDate.now().toString())
        val item4 = ListaItem("Localidad", "Málaga")

        /**
         * INSERTANDO ITEMS EN LISTA
         */
        listaDatosGenereales.add(item)
        listaDatosGenereales.add(item2)
        listaDatosGenereales.add(item3)
        listaDatosGenereales.add(item4)

        /**
         * ESTABLECIENDO TITULO
         */
        val textoDatosGenerales = listaRecyclerDatosGenerales.findViewById<TextView>(R.id.tituloMenu)
        textoDatosGenerales.text = "Datos Generales"

        /**
         * ESTABLECIENDO TITULO
         */
        val adapterDatosGenerales = SectionRecyclerViewListaItemAdapter(listaDatosGenereales)
        val recyclerMenuDatosGenerales = listaRecyclerDatosGenerales.findViewById<RecyclerView>(R.id.recyclerMenu)
        val layoutManagerDatosGenerales = LinearLayoutManager(this@EventoActivity, LinearLayoutManager.VERTICAL, false)
        recyclerMenuDatosGenerales.layoutManager = layoutManagerDatosGenerales
        recyclerMenuDatosGenerales.adapter = adapterDatosGenerales
        recyclerMenuDatosGenerales.visibility = View.VISIBLE

        /**
         * FUNCIÓN ONCLIC PARA OCULTAR/MOSTRAR LISTA
         */
        listaRecyclerDatosGenerales.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if (!mostrarDatosGenerales) {
                    recyclerMenuDatosGenerales.visibility = View.VISIBLE
                    mostrarDatosGenerales = true
                } else {
                    recyclerMenuDatosGenerales.visibility = View.GONE
                    mostrarDatosGenerales = false
                }
            }
        })

        /**
         * LISTA INFORMACION DE LA FIESTA
         */
        /**
         * CREACIÓN DE LISTA E ITEMS (CAMBIAR POR BASE DE DATOS)
         */
        val listaInformacionDeLaFiesta: ArrayList<ListaItem> = arrayListOf()
        val informacion1 = ListaItem("Dirección de Celebración", "c/Gondola 2")
        val informacion2 = ListaItem("Hora de comienzo", "17:30")
        val informacion3 = ListaItem("Nº de Festejados", "20")
        val informacion4 = ListaItem("Festejado", "Jaimito")
        val informacion5 = ListaItem("Observaciones", "Es alergico al azúcar")

        /**
         * INSERTANDO ITEMS EN LISTA
         */
        listaInformacionDeLaFiesta.add(informacion1)
        listaInformacionDeLaFiesta.add(informacion2)
        listaInformacionDeLaFiesta.add(informacion3)
        listaInformacionDeLaFiesta.add(informacion4)
        listaInformacionDeLaFiesta.add(informacion5)

        /**
         * ESTABLECIENDO TITULO
         */
        val textoInformacionDeLaFiesta = listaRecyclerInformacionDeLaFiesta.findViewById<TextView>(R.id.tituloMenu)
        textoInformacionDeLaFiesta.text = "Información de la Fiesta"

        /**
         * SINCRONIZACIÓN CON LOS ADAPTERS
         */
        val adapterInformacionDeLaFiesta = SectionRecyclerViewListaItemAdapter(listaInformacionDeLaFiesta)
        val recyclerMenuInformacionDeLaFiesta = listaRecyclerInformacionDeLaFiesta.findViewById<RecyclerView>(R.id.recyclerMenu)
        val layoutManagerInformacionDeLaFiesta = LinearLayoutManager(this@EventoActivity, LinearLayoutManager.VERTICAL, false)
        recyclerMenuInformacionDeLaFiesta.layoutManager = layoutManagerInformacionDeLaFiesta
        recyclerMenuInformacionDeLaFiesta.adapter = adapterInformacionDeLaFiesta
        recyclerMenuInformacionDeLaFiesta.visibility = View.VISIBLE

        /**
         * FUNCIÓN ONCLIC PARA OCULTAR/MOSTRAR LISTA
         */
        listaRecyclerInformacionDeLaFiesta.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if (!mostrarInformacionDeLaFiesta) {
                    recyclerMenuInformacionDeLaFiesta.visibility = View.VISIBLE
                    mostrarInformacionDeLaFiesta = true
                } else {
                    recyclerMenuInformacionDeLaFiesta.visibility = View.GONE
                    mostrarInformacionDeLaFiesta = false
                }
            }
        })

        /**
         * INFORMACIÓN DEL CLIENTE
         */
        /**
         * CREACIÓN DE LISTA E ITEMS (CAMBIAR POR BASE DE DATOS)
         */
        val listaInformacionDelCliente: ArrayList<ListaItem> = arrayListOf()
        val informacionCliente1 = ListaItem("Nombre", "Moises Benitez Perello")
        val informacionCliente2 = ListaItem("DNI", "26154789V")
        val informacionCliente3 = ListaItem("Teléfono", "655187458")

        /**
         * INSERTANDO ITEMS EN LISTA
         */
        listaInformacionDelCliente.add(informacionCliente1)
        listaInformacionDelCliente.add(informacionCliente2)
        listaInformacionDelCliente.add(informacionCliente3)

        /**
         * ESTABLECIENDO TITULO
         */
        val textoInformacionDelCliente = listaRecyclerInformacionDelCliente.findViewById<TextView>(R.id.tituloMenu)
        textoInformacionDelCliente.text = "Información del Cliente"

        /**
         * SINCRONIZACIÓN CON LOS ADAPTERS
         */
        val adapterInformacionDelCliente = SectionRecyclerViewListaItemAdapter(listaInformacionDelCliente)
        val recyclerMenuInformacionDelCliente = listaRecyclerInformacionDelCliente.findViewById<RecyclerView>(R.id.recyclerMenu)
        val layoutManagerInformacionDelCliente = LinearLayoutManager(this@EventoActivity, LinearLayoutManager.VERTICAL, false)
        recyclerMenuInformacionDelCliente.layoutManager = layoutManagerInformacionDelCliente
        recyclerMenuInformacionDelCliente.adapter = adapterInformacionDelCliente
        recyclerMenuInformacionDelCliente.visibility = View.VISIBLE

        /**
         * FUNCIÓN ONCLIC PARA OCULTAR/MOSTRAR LISTA
         */
        listaRecyclerInformacionDelCliente.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if (!mostrarInformacionDelCliente) {
                    recyclerMenuInformacionDelCliente.visibility = View.VISIBLE
                    mostrarInformacionDelCliente = true
                } else {
                    recyclerMenuInformacionDelCliente.visibility = View.GONE
                    mostrarInformacionDelCliente = false
                }
            }
        })
        /**
         * LISTA TRABAJADORES
         */
        /**
         * CREACIÓN DE LISTA E ITEMS (CAMBIAR POR BASE DE DATOS)
         */
        val listaTrabajadores: ArrayList<TrabajadorItem> = arrayListOf()
        val trabajador1 = TrabajadorItem(R.drawable.personal_icon, "Juan Carlos")
        val trabajador2 = TrabajadorItem(R.drawable.personal_icon, "Javier")

        /**
         * INSERTANDO ITEMS EN LISTA
         */
        listaTrabajadores.add(trabajador1)
        listaTrabajadores.add(trabajador2)

        /**
         * ESTABLECIENDO TITULO
         */
        val textoTrabajadores = listaRecyclerTrabajadores.findViewById<TextView>(R.id.tituloHeaderTrabajadores)
        textoTrabajadores.text = "Trabajadores"

        /**
         * SINCRONIZACIÓN CON LOS ADAPTERS
         */
        val adapterTrabajadores = SectionRecyclerViewTrabajadorAdapter(listaTrabajadores)
        val recyclerMenuTrabajadores = listaRecyclerTrabajadores.findViewById<RecyclerView>(R.id.recyclerHeaderTrabajadores)
        val layoutManagerTrabajadores = LinearLayoutManager(this@EventoActivity, LinearLayoutManager.VERTICAL, false)
        recyclerMenuTrabajadores.layoutManager = layoutManagerTrabajadores
        recyclerMenuTrabajadores.adapter = adapterTrabajadores
        recyclerMenuTrabajadores.visibility = View.VISIBLE

        /**
         * FUNCIÓN ONCLIC PARA OCULTAR/MOSTRAR LISTA
         */
        listaRecyclerTrabajadores.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if (!mostrarTrabajadores) {
                    recyclerMenuTrabajadores.visibility = View.VISIBLE
                    mostrarTrabajadores = true
                } else {
                    recyclerMenuTrabajadores.visibility = View.GONE
                    mostrarTrabajadores = false
                }
            }
        })
        /**
         * ADAPTER TRABAJADORES
         */
        adapterTrabajadores.setSectionRecyclerViewListener(object : SectionRecyclerViewTrabajadorAdapter.SectionRecyclerViewListener {
            override fun onItemClick(itemPosition: Int) {
            }
            /**
             * FUNCION ONCLICK PARA ELIMINAR ITEMS DE LA LISTA
             */
            override fun onDeleteClick(itemPosition: Int) {
                listaTrabajadores.removeAt(itemPosition)
                adapterTrabajadores.setListaTrabajadores(listaTrabajadores)
            }
        })

        /**
         * LISTA FICHAS
         */
        /**
         * CREACIÓN DE LISTA E ITEMS (CAMBIAR POR BASE DE DATOS)
         */
        val listaFichas: ArrayList<FichaItem> = arrayListOf()
        val ficha1 = FichaItem(R.drawable.ic_insert_drive_file_black_24dp, "Parte de Información")
        val ficha2 = FichaItem(R.drawable.ic_insert_drive_file_black_24dp, "Ficha Material [ENTRADA]")
        val ficha3 = FichaItem(R.drawable.ic_insert_drive_file_black_24dp, "Ficha Material [SALIDA]")

        /**
         * INSERTANDO ITEMS EN LISTA
         */
        listaFichas.add(ficha1)
        listaFichas.add(ficha2)
        listaFichas.add(ficha3)

        /**
         * ESTABLECIENDO TITULO
         */
        val textoFichas = listaRecyclerFichas.findViewById<TextView>(R.id.tituloMenu)
        textoFichas.text = "Fichas"

        /**
         * SINCRONIZACIÓN CON LOS ADAPTERS
         */
        val adapterFichas = SectionRecyclerViewFichaAdapter(listaFichas)
        val recyclerMenuFichas = listaRecyclerFichas.findViewById<RecyclerView>(R.id.recyclerMenu)
        val layoutManagerFichas = LinearLayoutManager(this@EventoActivity, LinearLayoutManager.VERTICAL, false)
        recyclerMenuFichas.layoutManager = layoutManagerFichas
        recyclerMenuFichas.adapter = adapterFichas
        recyclerMenuFichas.visibility = View.VISIBLE

        /**
         * FUNCIÓN ONCLIC PARA OCULTAR/MOSTRAR LISTA
         */
        listaRecyclerFichas.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if (!mostrarFichas) {
                    recyclerMenuFichas.visibility = View.VISIBLE
                    mostrarFichas = true
                } else {
                    recyclerMenuFichas.visibility = View.GONE
                    mostrarFichas = false
                }
            }
        })

        /**
         * FUNCION ONCLIC PARA AÑADIR UN ITEM A LISTA TRABAJADOR
         */
        val buttonNuevoTrabajador = findViewById<ImageView>(R.id.buttonNuevoTrabajador)

        buttonNuevoTrabajador.setOnClickListener {
            val intent = Intent(this, ListaPersonalActivity::class.java)
            startActivity(intent)
        }
    }
}
