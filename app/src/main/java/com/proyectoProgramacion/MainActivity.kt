package com.proyectoProgramacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //aqui seria el login (pag1)
        //si el login es correcto mandar a lista empleados
        val btlog =findViewById<Button>(R.id.Login)
        val mail = findViewById<EditText>(R.id.Edittxt_Email).text.toString()
        val password = findViewById<EditText>(R.id.Edittxt_Password).text.toString()
        val pin = findViewById<EditText>(R.id.editTextPin).text.toString().toInt()
        data class Persona(
            val email: String,
            val password: String,
            val pin: Int
        )
        var personas: Array<Persona> = arrayOf(
            Persona("correo@ejemplo.com","pasword123",1234),
            Persona("otro@ejemplo.com","pass456",5678)
        )
        btlog.setOnClickListener {
        }

    }
    fun login(mail: String, password: String, pin: Int, personas: Array<Persona>):Boolean{
        for(i in 0 until personas.size) {
            val mailBoss =
                if (mail == mailBoss) {

                }
        }
        }
    }
}