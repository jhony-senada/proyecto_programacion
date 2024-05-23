package com.proyectoProgramacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Lista_empleados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_empleados)

        /*data class Empleado (
            var fotoDePerfil: String,
            var Nombre: String,
            var CURP: String,
            var Seccion: String,
            var catLab: String)
            creo que cae en desuso por lo que se cambió
         */
        var empleados = ArrayList<Empleado?>(30)
        //este es el empleado ejemplo
        empleados.add(Empleado("foto1","Pipo Sarzamora","PIPO061518HQTBKFA4","Norte","ejecutivos"))
        //aqui todos los demas empleados :D
        //? me voy a volver locooooo no se como hacerlo aaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        //? y si mejor dejamos de poner las PFP
        //! ya no quiero hacer nada :C
        //para asegurarnos que sean 30 empleados:
        while (empleados.size<30){
            empleados.add(null)
        }

    }

}