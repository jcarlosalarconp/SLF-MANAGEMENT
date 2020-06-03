package com.example.slf_management.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.slf_management.R
import kotlinx.android.synthetic.main.activity_personal.*

class EventoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_evento)
        /*
          intent.extras?.let {
            val nombrePersonal = it.getString("nombrePersonal")
             val imagenPersonal = it.getInt("imagenPersonal")
             nombrePersonalActivity.text = nombrePersonal
             imagenPersonalActivity.setImageResource(imagenPersonal)
         }
         */
    }
}
