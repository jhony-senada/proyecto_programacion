package com.proyectoProgramacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Registrar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)
        data class Empleado (
            //var fotoDePerfil: String, esto deve ser aleatorio yo que se
            var Nombre: String,
            var CURP: String,
            var Seccion: String,
            var catLab: String)

    }
}