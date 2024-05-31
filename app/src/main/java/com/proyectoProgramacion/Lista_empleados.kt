package com.proyectoProgramacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged

class Lista_empleados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //se debe tomar en cuenta que esta cosa es basicamente lo de bases de datos, y NO estamos capacitados para hacerlo
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_empleados)
        val sihay=false //placeholder
        var separador =0
        test(separador,sihay)
        val btAtras= findViewById<ImageButton>(R.id.boton_atras)
        val btAdelante= findViewById<ImageButton>(R.id.boton_saltar)
        btAdelante.setOnClickListener{
            when (separador) {
                0->{
                    separador=siguiente(0,sihay)
                }
                1 -> {
                    separador=siguiente(1,sihay)
                }

                2 -> {
                    separador=siguiente(2,sihay)
                }

                3 -> {
                    separador=siguiente(3,sihay)
                }

                4 -> {
                    separador=siguiente(4,sihay)

                }
                else->{
                    Log.i("Error","Error en siguiente")
                }
            }
            /*if(separador==0){
                separador1= siguiente(separador)
                separador=1
            }else
            }*/
        }

        btAtras.setOnClickListener{
            when (separador) {
                0->{
                    separador=anterior(0,sihay)
                }
                1 -> {
                    separador=anterior(1,sihay)
                }

                2 -> {
                    separador=anterior(2,sihay)
                }

                3 -> {
                    separador=anterior(3,sihay)
                }

                4 -> {
                    separador=anterior(4,sihay)

                }
                5 ->{
                    separador=anterior(5,sihay)
                }
                else->{
                    Log.i("Error","Error en Anterior $separador")
                }
            }
        }
    }

    fun test(separador:Int,sihay:Boolean){
        val data1 = findViewById<TextView>(R.id.persona1Data)
        val data2 = findViewById<TextView>(R.id.persona2Data)
        val data3 = findViewById<TextView>(R.id.persona3Data)
        val data4 = findViewById<TextView>(R.id.persona4Data)
        val data5 = findViewById<TextView>(R.id.persona5Data)

        data class Empleado (
            //var fotoDePerfil: String, esto deve ser aleatorio yo que se
            var Nombre: String,
            var CURP: String,
            var Seccion: String,
            var catLab: String)
        var empleados = ArrayList<Empleado?>(30)
        //este es el empleado ejemplo
        empleados.add(Empleado("Pipo Sarzamora","PIPO061518HQTBKFA4","Norte","ejecutivos"))
        if(/*el paquete que debe llegar de registrar*/sihay==true){
            //aqui se pone el empleado generado en Regisrar al chopo
        }else{
            empleados.add(Empleado("Pipo Sarzamora","PIPO061518HQTBKFA4","Norte","ejecutivos"))
        }
        empleados.add(Empleado("Pipo Sarzamora","PIPO061518HQTBKFA4","Norte","ejecutivos"))
        empleados.add(Empleado("Pipo Sarzamora","PIPO061518HQTBKFA4","Norte","ejecutivos"))
        empleados.add(Empleado("El P I P O","PIPO061518HQTBKFA4","Norte","ejecutivos"))

        //aqui todos los demas empleados :D
        //para asegurarnos que sean 30 empleados:
        while (empleados.size<=29){
            empleados.add(Empleado("espacio vacio","espacio vacio","espacio vacio","espacio vacio"))
        }
        val btEliminar = findViewById<Button>(R.id.btEliminar)
        val btEditar = findViewById<Button>(R.id.btEditar)
        val btRegistrar = findViewById<Button>(R.id.btRegistrar)
        val btAceptar = findViewById<Button>(R.id.btAceptar)
        btAceptar.setOnClickListener{
            val selector = findViewById<EditText>(R.id.seleccionID)
            var selectorV=selector.text.toString()
            var eleccion=if (selectorV.isNotEmpty() ){
                selectorV.toInt()
            }else{
                -1
            }
            if(eleccion>29){
                eleccion=-1
            }
            btEliminar.setOnClickListener{//el de eliminar
                if (eleccion==-1){
                    Log.i("Error","error en eliminar")
                }else {
                    val Eliminado= Empleado("espacio vacio","espacio vacio","espacio vacio","espacio vacio")
                    empleados.removeAt(eleccion)
                    empleados.add(eleccion,Eliminado)
                    //solo puede sobreescribir el ultimo ID colocado, no vi otra forma de hacerlo. -C
                    //NVM si pude -C
                    val empleado=empleados[eleccion]?.CURP.toString()
                    Log.i("Error","Jala el eliminar? lugar: $eleccion, $empleado")
                    if(separador==0){
                        for (i in 0 until 5){
                            var Datos = "$i "+(empleados[i]?.Nombre ?:"espacio vacio") +" "+ (empleados[i]?.CURP ?:"espacio vacio") +" "+ (empleados[i]?.catLab
                                ?: "espacio vacio") +" "+ (empleados[i]?.Seccion ?: "espacio vacio")
                            when (i){
                                0 -> data1.setText(Datos)
                                1 -> data2.setText(Datos)
                                2 -> data3.setText(Datos)
                                3 -> data4.setText(Datos)
                                4 -> data5.setText(Datos)
                                else -> Log.i("Error","no es? $Datos")
                            }
                        }
                    }else if(separador ==1){
                        for (i in 5 until 10){
                            var Datos = "$i "+(empleados[i]?.Nombre ?:"espacio vacio") +" "+ (empleados[i]?.CURP ?:"espacio vacio") +" "+ (empleados[i]?.catLab
                                ?: "espacio vacio") +" "+ (empleados[i]?.Seccion ?: "espacio vacio")
                            when (i){
                                5 -> data1.setText(Datos)
                                6 -> data2.setText(Datos)
                                7 -> data3.setText(Datos)
                                8 -> data4.setText(Datos)
                                9 -> data5.setText(Datos)
                                else -> Log.i("Error","no es? $Datos")
                            }
                        }
                    }else if(separador ==2){
                        for (i in 10 until 15){
                            var Datos = "$i "+(empleados[i]?.Nombre ?:"espacio vacio") +" "+ (empleados[i]?.CURP ?:"espacio vacio") +" "+ (empleados[i]?.catLab
                                ?: "espacio vacio") +" "+ (empleados[i]?.Seccion ?: "espacio vacio")
                            when (i){
                                10 -> data1.setText(Datos)
                                11 -> data2.setText(Datos)
                                12 -> data3.setText(Datos)
                                13 -> data4.setText(Datos)
                                14 -> data5.setText(Datos)
                                else -> Log.i("Error","no es? $Datos")
                            }
                        }
                    }else if(separador ==3){
                        for (i in 15 until 20){
                            var Datos = "$i "+(empleados[i]?.Nombre ?:"espacio vacio") +" "+ (empleados[i]?.CURP ?:"espacio vacio") +" "+ (empleados[i]?.catLab
                                ?: "espacio vacio") +" "+ (empleados[i]?.Seccion ?: "espacio vacio")
                            when (i){
                                15 -> data1.setText(Datos)
                                16 -> data2.setText(Datos)
                                17 -> data3.setText(Datos)
                                18 -> data4.setText(Datos)
                                19 -> data5.setText(Datos)
                                else -> Log.i("Error","no es? $Datos")
                            }
                        }
                    }else if(separador ==4){
                        for (i in 20 until 25){
                            var Datos = "$i "+(empleados[i]?.Nombre ?:"espacio vacio") +" "+ (empleados[i]?.CURP ?:"espacio vacio") +" "+ (empleados[i]?.catLab
                                ?: "espacio vacio") +" "+ (empleados[i]?.Seccion ?: "espacio vacio")
                            when (i){
                                20 -> data1.setText(Datos)
                                21 -> data2.setText(Datos)
                                22 -> data3.setText(Datos)
                                23 -> data4.setText(Datos)
                                24 -> data5.setText(Datos)
                                else -> Log.i("Error","no es? $Datos")
                            }
                        }
                    }else if(separador ==5){
                        for (i in 25 until 30){
                            var Datos = "$i "+(empleados[i]?.Nombre ?:"espacio vacio") +" "+ (empleados[i]?.CURP ?:"espacio vacio") +" "+ (empleados[i]?.catLab
                                ?: "espacio vacio") +" "+ (empleados[i]?.Seccion ?: "espacio vacio")
                            when (i){
                                25 -> data1.setText(Datos)
                                26 -> data2.setText(Datos)
                                27 -> data3.setText(Datos)
                                28 -> data4.setText(Datos)
                                29 -> data5.setText(Datos)
                                else -> Log.i("Error","no es? $Datos")
                            }
                        }
                    }else{
                        Log.i("Error","ALgo salio mal, ayuda")
                    }
                }
            }
            btEditar.setOnClickListener{
                //mandar_Editar()
            }

            btRegistrar.setOnClickListener{
                //mandar_registrar()
            }
        }



        if(separador==0){
            for (i in 0 until 5){
                var Datos = "$i "+(empleados[i]?.Nombre ?:"espacio vacio") +" "+ (empleados[i]?.CURP ?:"espacio vacio") +" "+ (empleados[i]?.catLab
                    ?: "espacio vacio") +" "+ (empleados[i]?.Seccion ?: "espacio vacio")
                when (i){
                    0 -> data1.setText(Datos)
                    1 -> data2.setText(Datos)
                    2 -> data3.setText(Datos)
                    3 -> data4.setText(Datos)
                    4 -> data5.setText(Datos)
                    else -> Log.i("Error","no es? $Datos")
                }
            }
        }else if(separador ==1){
            for (i in 5 until 10){
                var Datos = "$i "+(empleados[i]?.Nombre ?:"espacio vacio") +" "+ (empleados[i]?.CURP ?:"espacio vacio") +" "+ (empleados[i]?.catLab
                    ?: "espacio vacio") +" "+ (empleados[i]?.Seccion ?: "espacio vacio")
                when (i){
                    5 -> data1.setText(Datos)
                    6 -> data2.setText(Datos)
                    7 -> data3.setText(Datos)
                    8 -> data4.setText(Datos)
                    9 -> data5.setText(Datos)
                    else -> Log.i("Error","no es? $Datos")
                }
            }
        }else if(separador ==2){
            for (i in 10 until 15){
                var Datos = "$i "+(empleados[i]?.Nombre ?:"espacio vacio") +" "+ (empleados[i]?.CURP ?:"espacio vacio") +" "+ (empleados[i]?.catLab
                    ?: "espacio vacio") +" "+ (empleados[i]?.Seccion ?: "espacio vacio")
                when (i){
                    10 -> data1.setText(Datos)
                    11 -> data2.setText(Datos)
                    12 -> data3.setText(Datos)
                    13 -> data4.setText(Datos)
                    14 -> data5.setText(Datos)
                    else -> Log.i("Error","no es? $Datos")
                }
            }
        }else if(separador ==3){
            for (i in 15 until 20){
                var Datos = "$i "+(empleados[i]?.Nombre ?:"espacio vacio") +" "+ (empleados[i]?.CURP ?:"espacio vacio") +" "+ (empleados[i]?.catLab
                    ?: "espacio vacio") +" "+ (empleados[i]?.Seccion ?: "espacio vacio")
                when (i){
                    15 -> data1.setText(Datos)
                    16 -> data2.setText(Datos)
                    17 -> data3.setText(Datos)
                    18 -> data4.setText(Datos)
                    19 -> data5.setText(Datos)
                    else -> Log.i("Error","no es? $Datos")
                }
            }
        }else if(separador ==4){
            for (i in 20 until 25){
                var Datos = "$i "+(empleados[i]?.Nombre ?:"espacio vacio") +" "+ (empleados[i]?.CURP ?:"espacio vacio") +" "+ (empleados[i]?.catLab
                    ?: "espacio vacio") +" "+ (empleados[i]?.Seccion ?: "espacio vacio")
                when (i){
                    20 -> data1.setText(Datos)
                    21 -> data2.setText(Datos)
                    22 -> data3.setText(Datos)
                    23 -> data4.setText(Datos)
                    24 -> data5.setText(Datos)
                    else -> Log.i("Error","no es? $Datos")
                }
            }
        }else if(separador ==5){
            for (i in 25 until 30){
                var Datos = "$i "+(empleados[i]?.Nombre ?:"espacio vacio") +" "+ (empleados[i]?.CURP ?:"espacio vacio") +" "+ (empleados[i]?.catLab
                    ?: "espacio vacio") +" "+ (empleados[i]?.Seccion ?: "espacio vacio")
                when (i){
                    25 -> data1.setText(Datos)
                    26 -> data2.setText(Datos)
                    27 -> data3.setText(Datos)
                    28 -> data4.setText(Datos)
                    29 -> data5.setText(Datos)
                    else -> Log.i("Error","no es? $Datos")
                }
            }
        }else{
            Log.i("Error","ALgo salio mal, ayuda")
        }
    }
/*
    fun mandar_registrar(ID:Int){
        if (ID ==-1){

        }else{

        }
    }
    fun mandar_Editar(ID:Int){
        if (ID ==-1){

        }else{

        }
    }
    fun eliminar(ID:Int){
        if (ID ==-1){

        }else{

        }
    }*/
    fun siguiente(separador: Int,sihay:Boolean): Int{
        if (separador <5){
            val separadorplus=separador+1
            test(separadorplus,sihay)
            Log.i("Valores","mas 1 $separadorplus")
            return separadorplus
        }else {
            Log.i("Error","no se puede $separador")
            return separador
        }
    }
    fun anterior(separador: Int,sihay: Boolean): Int{
        if (separador >0){
            val separadorminus=separador-1
            test(separadorminus,sihay)
            Log.i("Valores","menos 1 $separadorminus")
            return separadorminus
        }else {
            Log.i("Error","no se puede $separador")
            return separador
        }
    }

}