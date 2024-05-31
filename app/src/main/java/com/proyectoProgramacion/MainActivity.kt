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
        val btlog = findViewById<Button>(R.id.btLogin)
        btlog.setOnClickListener {
            val mail = findViewById<EditText>(R.id.txt_email).text
            val mailV=mail.toString()
            val password = findViewById<EditText>(R.id.txt_pass).text
            val passwordV =password.toString()
            val pin = findViewById<EditText>(R.id.txt_pin).text.toString()
            val pinV= if(pin.isNotEmpty()){
                pin.toInt()
            }else{
                0
            }
            Log.i("Valores","s2 $mailV , $passwordV , $pinV")
            login(mailV, passwordV, pinV)

            Log.i("ver","parte 3 jala")
        }


    }
    /*
    * instrucciones para subir a Git repository
    * git add .
    * git commit -m "el mensaje aqui"
    * git push origin master
    * */
    fun login(mail: String, password: String, pin: Int) {
        val Mail=mail
        val Password=password
        val Pin = pin
        data class Persona(
            val email: String,
            val password: String,
            val pin: Int
        )
        Log.i("Valores","$Mail , $password , $Pin")
        val personas: Array<Persona> = arrayOf(
            Persona("correo@ejemplo.com", "pasword123", 1234),
            Persona("otro@ejemplo.com", "pass456", 5678),
            Persona("test","test",5)//quitar despues, es para probar
        )
        for (i in personas.indices) {

            var mailBoss = personas[i].email
            var passBoss = personas[i].password
            var pinBoss = personas[i].pin
            Log.i("Valores","email $mailBoss")
            Log.i("Valores","password $passBoss")
            Log.i("Valores", "pin $pinBoss")
            if (Mail == mailBoss) {
                if (Password == passBoss) {
                    if (Pin == pinBoss) {
                        val liga = Intent(this, Lista_empleados::class.java)
                        startActivity(liga)
                        break
                    }else{Log.i("Error","Pin")}
                }else{Log.i("Error","contraseña") }
            }else{
                //la warning aqui
                Log.i("Error","correo")
            }
        }
    }
}
