package com.proyectoProgramacion
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //aqui seria el login (pag1)
        //si el login es correcto mandar a lista empleados
        val btlog = findViewById<Button>(R.id.Login)
        val mail = findViewById<EditText>(R.id.Edittxt_Email).text.toString()
        val password = findViewById<EditText>(R.id.Edittxt_Password).text.toString()
        val pin = findViewById<EditText>(R.id.editTextPin).text.toString()
        val pinV= if(pin.isNotEmpty()){
            pin.toInt()
        }else{
            0
        }
        Log.i("ver","parte 1 jala")
        btlog.setOnClickListener {
            login(mail, password, pinV)
            Log.i("ver","parte 3 jala")
        }


    }
    fun login(mail: String, password: String, pin: Int) {
        data class Persona(
            val email: String,
            val password: String,
            val pin: Int
        )
        Log.i("ver","parte 2 jala")
        val personas: Array<Persona> = arrayOf(
            Persona("correo@ejemplo.com", "pasword123", 1234),
            Persona("otro@ejemplo.com", "pass456", 5678)
        )
        for (i in personas.indices) {
            var mailBoss = personas[i].email
            var passBoss = personas[i].password
            var pinBoss = personas[i].pin
            if (mail == mailBoss) {
                if (password == passBoss) {
                    if (pin == pinBoss) {
                        val liga = Intent(this, Lista_empleados::class.java)
                        startActivity(liga)
                    }
                }
            }else{
                //la warning aqui
            }
        }
    }
}
