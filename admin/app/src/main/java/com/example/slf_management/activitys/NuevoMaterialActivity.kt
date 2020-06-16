package com.example.slf_management.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.slf_management.MainActivity
import com.example.slf_management.R
import com.example.slf_management.adapter.MaterialAdapter
import com.example.slf_management.adapter.NuevoElementoItemAdapter
import com.example.slf_management.fragments.MaterialFragment
import com.example.slf_management.items.ListaMateriales
import com.example.slf_management.items.MaterialItem
import com.example.slf_management.items.NuevoElementoItem
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_material.*
import kotlinx.android.synthetic.main.activity_nuevo_material.*
import java.util.ArrayList

class NuevoMaterialActivity : AppCompatActivity() {
    private val db by lazy { FirebaseFirestore.getInstance()}
    private var listaMateriales = ListaMateriales(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_material)


        val nombreEditText = findViewById<EditText>(R.id.nombreNuevoMaterial)
        val tipoEditText = findViewById<EditText>(R.id.tipoNuevoMaterial)

        val buttonAceptar = findViewById<Button>(R.id.buttonAceptarNuevoMaterial)

        buttonAceptar.setOnClickListener{

            db.collection("slf-management").document("material").get().addOnCompleteListener {
                task ->
                if (task.isSuccessful){
                    listaMateriales = task.result!!.toObject(ListaMateriales::class.java)!!

                    var materialItem = MaterialItem(listaMateriales.listaMaterial.size+1, nombreEditText.text.toString(), tipoEditText.text.toString(), true, 0, arrayListOf())
                    listaMateriales.listaMaterial.add(materialItem)
                    val map = hashMapOf<String, Any>("listaMaterial" to listaMateriales)
                    db.collection("slf-management").document("material").set(map).addOnCompleteListener{task ->
                        if (task.isSuccessful){
                            Toast.makeText(this, "Material añadido con exito", Toast.LENGTH_SHORT).show()
                            finish()
                        }else{
                            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }

                }else{
                    Toast.makeText(this@NuevoMaterialActivity, task.exception.toString(), Toast.LENGTH_LONG).show()
                }
            }

        }
    }


}