package com.proyectoProgramacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.util.Log


class Editar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar)
        var empleadotemplate: MainActivity.Empleado? = MainActivity.Empleado("","","","")
        var empleados: ArrayList<MainActivity.Empleado>? =
            intent.getParcelableArrayListExtra("empleados")
        var lugar: Int = intent.getIntExtra("lugar", -1)
        val Confirmar = findViewById<Button>(R.id.Confirmar)
        val nombre = findViewById<EditText>(R.id.nombre)
        val curp = findViewById<EditText>(R.id.curp)
        var seccionSeleccionada = ""
        var catLabSelec = ""
        if (lugar != -1) {
            //aqui van si es diferente a -1 osea que es un valor valido
            for (i in empleados?.indices!!) {
                if (i == lugar) {
                    empleadotemplate = MainActivity.Empleado(
                        empleados[i].Nombre,
                        empleados[i].CURP,
                        empleados[i].Seccion,
                        empleados[i].catLab
                    )
                    break
                }
            }
            nombre.setText(empleadotemplate?.Nombre)
            curp.setText(empleadotemplate?.CURP)
            val spinerSeccion = findViewById<Spinner>(R.id.seccion_spiner)
            val adaptador = ArrayAdapter.createFromResource(
                this,
                R.array.secciones,
                android.R.layout.simple_spinner_item
            )
            adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinerSeccion.adapter = adaptador

            if (empleadotemplate?.Seccion == "Norte") {
                spinerSeccion.setSelection(0)
            } else {
                spinerSeccion.setSelection(1)
            }

            //debo repetirlo para el otro spiner -C
            spinerSeccion.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    seccionSeleccionada = parent.getItemAtPosition(position).toString()
                    //haz algo con el valor seleccionado -C
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Opcional: Maneja la situación donde no se selecciona ningún elemento -C
                    seccionSeleccionada = "Norte"
                }
            }
            //se debe hacer lo mismo para el otro spiner -C
            //lo del otro spiner -C
            val spinerCatLab = findViewById<Spinner>(R.id.cat_lab_spinner)
            val adaptador2 = ArrayAdapter.createFromResource(
                this,
                R.array.cat_lab,
                android.R.layout.simple_spinner_item
            )
            adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinerCatLab.adapter = adaptador2

            when (empleadotemplate?.catLab) {
                "ejecutivos" -> spinerCatLab.setSelection(0)
                "directivos" -> spinerCatLab.setSelection(1)
                "gerentes" -> spinerCatLab.setSelection(2)
                "empleados" -> spinerCatLab.setSelection(3)
            }
            //agarrar datos del spinner -C
            spinerCatLab.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    catLabSelec = parent.getItemAtPosition(position).toString()
                    //haz algo con el valor seleccionado -C
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Opcional: Maneja la situación donde no se selecciona ningún elemento -C
                    catLabSelec = "empleados"
                }
            }
        } else {
            //aqui va si no es un valor valido o no hay nada
            val liga = Intent(this, Lista_empleados::class.java)
            liga.putParcelableArrayListExtra("empleados", empleados)
            startActivity(liga)
        }
        //aqui empieza lo del spiner -C


        Confirmar.setOnClickListener {
            leerDatos(lugar,empleados,seccionSeleccionada,catLabSelec,nombre,curp)
        }
    }

    fun leerDatos(
        lugar: Int,
        empleados: ArrayList<MainActivity.Empleado>?,
        seccionSeleccionada: String,
        catLabSelec: String,
        nombre: EditText,
        curp: EditText, ) {


        val Nombre = nombre.text.toString()
        val Curp = curp.text.toString()
        val empleadotemp: MainActivity.Empleado

        if (Nombre.isBlank() || Curp.isBlank()) {
            Log.i("error", "alguno no esta completo")
            empleadotemp = MainActivity.Empleado(
                "no hay nombre",
                "o no hay curp",
                seccionSeleccionada,
                catLabSelec
            )
        } else {
            empleadotemp = MainActivity.Empleado(Nombre, Curp, seccionSeleccionada, catLabSelec)
            empleados?.removeAt(lugar)
            empleados?.add(lugar, empleadotemp)
        }
        val liga = Intent(this, Lista_empleados::class.java)
        liga.putParcelableArrayListExtra("empleados", empleados)
        startActivity(liga)

    }
}
