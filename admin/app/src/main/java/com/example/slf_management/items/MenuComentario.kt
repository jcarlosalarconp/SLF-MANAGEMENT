package com.example.slf_management.items

import java.time.LocalDate

data class MenuComentario (
    var menu : ArrayList<Section>
)

data class Section (
    var nombre : String,
    var comentarios : ArrayList<Comentario>,
    var isExpanded : Boolean
)

data class Comentario (
    var nombre : String,
    var comentario : String,
    var fecha : String
){
    constructor():this("","","")
}