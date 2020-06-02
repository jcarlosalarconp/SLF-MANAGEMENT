package com.example.slf_management.items

import java.time.LocalDate

data class MenuEvento (
        var menu : ArrayList<SectionEvento>
)

data class SectionEvento (
        var nombre : String,
        var eventos : ArrayList<Evento>,
        var isExpanded : Boolean
)

data class Evento (
        var id : Int,
        var localidad : String,
        var servicioSolicitado : String,
        var fecha : LocalDate
)