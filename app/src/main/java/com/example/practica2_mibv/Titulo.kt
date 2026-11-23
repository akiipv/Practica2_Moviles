package com.example.practica2_mibv

import java.time.LocalDate

data class Titulo(
    val titulo: String = "Sin titulo",
    val fechaLanzamiento: String = "11-11-2011",
    val descripcion: String = "Descripción",
    val puntuación: Int = 5,
    val plataforma: String = "Tengo sueño",
    val nJugadores: Int = 0
    )