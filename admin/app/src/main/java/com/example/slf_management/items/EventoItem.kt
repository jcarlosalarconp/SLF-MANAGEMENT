package com.example.slf_management.items

import java.sql.Timestamp
import java.time.LocalDate

class EventoItem(val idEvento:Int, val servicioSolicitado:String, val observaciones:String, val precio:Int, val nombreCliente:String, val dniCliente:String, val tlfCliente:Int, val localidad:String, val fecha: Timestamp, val direccionCelebracion:String, val numInvitados:Int, val nombreFestejado:String, val trabajadoresEvento:ArrayList<PersonalItem>, val comentariosEvento:ArrayList<ComentarioItem>) {
}