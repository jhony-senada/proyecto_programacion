package com.proyectoProgramacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class Lista_empleados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_empleados)
            /*if(i==0 ||i==5 ||i==10 ||i==15 ||i==20||i==25){

            }else if(i==1||i==6 ||i==11 ||i==16 ||i==21||i==26){

            }else if(i==2||i==7 ||i==12 ||i==17 ||i==23||i==27){

            }else if(i==3||i==8 ||i==13 ||i==18 ||i==24||i==28){

            }else if(i==4||i==9 ||i==14 ||i==19 ||i==25||i==29){

            }*/
        var separador =0
        var separador1 =0//no se si es util pero lo dejo
        test(separador)
        val btAtras= findViewById<ImageButton>(R.id.boton_atras)
        val btAdelante= findViewById<ImageButton>(R.id.boton_saltar)
        btAdelante.setOnClickListener{
            when (separador) {
                0->{
                    separador=siguiente(0)
                }
                1 -> {
                    separador=siguiente(1)
                }

                2 -> {
                    separador=siguiente(2)
                }

                3 -> {
                    separador=siguiente(3)
                }

                4 -> {
                    separador=siguiente(4)

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
                    separador=anterior(0)
                }
                1 -> {
                    separador=anterior(1)
                }

                2 -> {
                    separador=anterior(2)
                }

                3 -> {
                    separador=anterior(3)
                }

                4 -> {
                    separador=anterior(4)

                }
                5 ->{
                    separador=anterior(5)
                }
                else->{
                    Log.i("Error","Error en Anterior $separador")
                }
            }
        }
    }

    fun test(separador:Int){
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
        empleados.add(Empleado("Pipo Sarzamora","PIPO061518HQTBKFA4","Norte","ejecutivos"))
        empleados.add(Empleado("Pipo Sarzamora","PIPO061518HQTBKFA4","Norte","ejecutivos"))
        empleados.add(Empleado("Pipo Sarzamora","PIPO061518HQTBKFA4","Norte","ejecutivos"))
        empleados.add(Empleado("El P I P O","PIPO061518HQTBKFA4","Norte","ejecutivos"))

        //aqui todos los demas empleados :D
        //para asegurarnos que sean 30 empleados:
        while (empleados.size<=29){
            empleados.add(Empleado("espacio vacio","espacio vacio","espacio vacio","espacio vacio"))
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

    fun mandar_registrar(){

    }
    fun mandar_Editar(){

    }
    fun eliminar(){

    }
    fun siguiente(separador: Int): Int{
        if (separador <5){
            val separadorplus=separador+1
            test(separadorplus)
            Log.i("Valores","mas 1 $separadorplus")
            return separadorplus
        }else {
            Log.i("Error","no se puede $separador")
            return separador
        }
    }
    fun anterior(separador: Int): Int{
        if (separador >0){
            val separadorminus=separador-1
            test(separadorminus)
            Log.i("Valores","menos 1 $separadorminus")
            return separadorminus
        }else {
            Log.i("Error","no se puede $separador")
            return separador
        }
    }

}