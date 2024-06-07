package com.proyectoProgramacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import java.text.FieldPosition

class Registrar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)
        var empleados: ArrayList<MainActivity.Empleado>?=intent.getParcelableArrayListExtra("empleados")
        for(i in empleados?.indices!!){
            if(empleados.get(i).CURP=="espacio vacio"){
                if(empleados.get(i).Nombre=="espacio vacio"){
                    if(empleados.get(i).Seccion=="espacio vacio"){
                        if(empleados.get(i).catLab=="espacio vacio"){
                            Log.i("Valores","todos vacios")
                            leerDatos(i,empleados)
                            break
                        }else{
                            Log.i("Valores","cat lab ${empleados.get(i).catLab}")
                        }
                    }else{
                        Log.i("Valores","cat lab ${empleados.get(i).Seccion}")
                    }
                }else{
                    Log.i("Valores","cat lab ${empleados.get(i).Nombre}")
                }
            }else{
                Log.i("Valores","cat lab ${empleados.get(i).CURP}")
            }
        }

    }//fin de crear
    fun leerDatos(lugar:Int, empleados:ArrayList<MainActivity.Empleado>?){
        val Nombre=findViewById<EditText>(R.id.Nombre).text.toString()
        val Curp=findViewById<EditText>(R.id.Curp).text.toString()
        //aqui empieza lo del spiner -C
        val spinerSeccion=findViewById<Spinner>(R.id.seccion)
        val adaptador=ArrayAdapter.createFromResource(this,R.array.secciones,android.R.layout.simple_spinner_item)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinerSeccion.adapter=adaptador
        //debo repetirlo para el otro spiner -C
        spinerSeccion.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>,view:View,position: Int,id: Long) {
                val seleccionado1=parent.getItemAtPosition(position).toString()
                //haz algo con el valor seleccionado -C
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                // Opcional: Maneja la situación donde no se selecciona ningún elemento -C
            }
        }
    //se debe hacer lo mismo para el otro spiner -C
        if(Nombre=="" ||Curp==""){
            Log.i("error","alguno no esta completo")
        }else{/*
            MainActivity.Empleado(Nombre,Curp,)
            empleados.add(lugar,)*/
        }
    }

}