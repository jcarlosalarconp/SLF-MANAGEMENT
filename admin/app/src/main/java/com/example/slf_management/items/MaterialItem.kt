package com.example.slf_management.items

class MaterialItem(val idMaterial:Int, val nombreMaterial:String,val tipoMaterial:String, val disponibilidadMaterial:Boolean, val imagenMaterial: Int, val comentariosMaterial: ArrayList<ComentarioItem>) {
    constructor():this(0, "", "", true, 0, arrayListOf())
}