package com.proyectoProgramacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import java.text.FieldPosition

class Registrar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)
        val empleadotemplate:MainActivity.Empleado?
        var empleados: ArrayList<MainActivity.Empleado>?=intent.getParcelableArrayListExtra("empleados")
        val Confirmar = findViewById<Button>(R.id.Agregar)
        var seccionSeleccionada=""
        var catLabSelec=""
        //aqui empieza lo del spiner -C
        val spinerSeccion=findViewById<Spinner>(R.id.seccion)
        val adaptador=ArrayAdapter.createFromResource(this,R.array.secciones,android.R.layout.simple_spinner_item)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinerSeccion.adapter=adaptador
        //debo repetirlo para el otro spiner -C
        spinerSeccion.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>,view:View,position: Int,id: Long) {
                seccionSeleccionada=parent.getItemAtPosition(position).toString()
                //haz algo con el valor seleccionado -C
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                // Opcional: Maneja la situación donde no se selecciona ningún elemento -C
                seccionSeleccionada="Norte"
            }
        }
        //se debe hacer lo mismo para el otro spiner -C
        //lo del otro spiner -C
        val spinerCatLab = findViewById<Spinner>(R.id.catLab)
        val adaptador2 =ArrayAdapter.createFromResource(this,R.array.cat_lab,android.R.layout.simple_spinner_item)
        adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinerCatLab.adapter=adaptador2
        //agarrar datos del spinner -C
        spinerCatLab.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>,view:View,position: Int,id: Long) {
                catLabSelec=parent.getItemAtPosition(position).toString()
                //haz algo con el valor seleccionado -C
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                // Opcional: Maneja la situación donde no se selecciona ningún elemento -C
                catLabSelec="empleados"
            }
        }
        Confirmar.setOnClickListener {
            for (i in empleados?.indices!!) {
                if (empleados.get(i).CURP == "espacio vacio") {
                    if (empleados.get(i).Nombre == "espacio vacio") {
                        if (empleados.get(i).Seccion == "espacio vacio") {
                            if (empleados.get(i).catLab == "espacio vacio") {
                                Log.i("Valores", "todos vacios")
                                leerDatos(i, empleados,seccionSeleccionada, catLabSelec)
                                break
                            } else {
                                Log.i("Valores", "cat lab ${empleados.get(i).catLab}")
                            }
                        } else {
                            Log.i("Valores", "cat lab ${empleados.get(i).Seccion}")
                        }
                    } else {
                        Log.i("Valores", "cat lab ${empleados.get(i).Nombre}")
                    }
                } else {
                    Log.i("Valores", "cat lab ${empleados.get(i).CURP}")
                }
            }
        }
    }//fin de crear
    fun leerDatos(lugar:Int, empleados:ArrayList<MainActivity.Empleado>?,seccionSeleccionada:String,catLabSelec:String) {
        val Nombre=findViewById<EditText>(R.id.Nombre).text.toString()
        val Curp=findViewById<EditText>(R.id.Curp).text.toString()
        val empleadotemp:MainActivity.Empleado

        if(Nombre.isBlank()|| Curp.isBlank()){
            Log.i("error","alguno no esta completo")
            empleadotemp=MainActivity.Empleado("no hay nombre","o no hay curp",seccionSeleccionada,catLabSelec)
        }else{
            Log.i("valores","seccion: $seccionSeleccionada , catLab: $catLabSelec")
            empleadotemp=MainActivity.Empleado(Nombre,Curp,seccionSeleccionada,catLabSelec)
            empleados?.add(lugar,empleadotemp)
            //empleados?.add(lugar,empleadotemp)
        }
        val liga = Intent(this, Lista_empleados::class.java)
        liga.putParcelableArrayListExtra("empleados",empleados)
        startActivity(liga)
    }

}