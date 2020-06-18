package com.example.slf_management.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.slf_management.R

class PersonalActivity : AppCompatActivity() {

    private val nombrePersonalActivity by lazy { findViewById<TextView>(R.id.nombrePersonalActivity) }
    private val imagenPersonalActivity by lazy { findViewById<ImageView>(R.id.imagenPersonalActivity) }

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
        /**
         * INSERTANDO TEXTO
         */
        val nombrePersonal = findViewById<EditText>(R.id.nombrePersonal)
        val telefonoPersonal = findViewById<EditText>(R.id.telefonoPersonal)
        val dniPersonal = findViewById<EditText>(R.id.dniPersonal)
        val direccionPersonal = findViewById<EditText>(R.id.direccionPersonal)
        val telefonoExternoPersonal = findViewById<EditText>(R.id.telefonoExternoPersonal)
        val numeroSSPersonal = findViewById<EditText>(R.id.numeroSSPersonal)

        nombrePersonal.setText("Juan Carlos")
        telefonoPersonal.setText("655147852")
        dniPersonal.setText("254786325V")
        direccionPersonal.setText("c/ Dos Aceras 3")
        telefonoExternoPersonal.setText("658985214")
        numeroSSPersonal.setText("985147652")

        /**
         * IMAGEN
         */
        val imagen = findViewById<ImageView>(R.id.imagenPersonalActivity)
        imagen.setOnClickListener{
            Toast.makeText(this, "Hacer foto", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * INSERTANDO EL BOTON EDITAR
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit_toolbar, menu)
        return true
    }

    /**
     * FUNCION ONCLICK DEL BOTON EDITAR
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Toast.makeText(this, "Cambios Guardados", Toast.LENGTH_SHORT).show()
        when(item.itemId){
            R.id.editProfile -> {}
        }
        return true
    }

}
