package com.proyectoProgramacion
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.os.Parcel
import android.os.Parcelable
import java.util.*
class MainActivity : AppCompatActivity() {
    data class Empleado (
        //var fotoDePerfil: String, esto debe ser aleatorio yo que se
        var Nombre: String,
        var CURP: String,
        var Seccion: String,
        var catLab: String
    ): Parcelable{
        constructor(parcel: Parcel):this(
            parcel.readString()?:"",
            parcel.readString()?:"",
            parcel.readString()?:"",
            parcel.readString()?:""
            )

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(Nombre)
            parcel.writeString(CURP)
            parcel.writeString(Seccion)
            parcel.writeString(catLab)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Empleado> {
            override fun createFromParcel(parcel: Parcel): Empleado {
                return Empleado(parcel)
            }

            override fun newArray(size: Int): Array<Empleado?> {
                return arrayOfNulls(size)
            }
        }
    }
    var empleados = arrayListOf<Empleado>(
        Empleado("Pipo Sarzamora","PIPO061518HQTBKFA4","Norte","ejecutivos"),
        Empleado("Pipo Sarzamora","PIPO061518HQTBKFA4","Sur","ejecutivos"),
        Empleado("Pipo Sarzamora","PIPO061518HQTBKFA4","Norte","ejecutivos"),
        Empleado("Pipo Sarzamora","PIPO061518HQTBKFA4","Sur","ejecutivos"),
        Empleado("Pipo Sarzamora","PIPO061518HQTBKFA4","Norte","ejecutivos"),
        Empleado("El P I P O","PIPO061518HQTBKFA4","Norte","ejecutivos")
    )
    //este es el empleado ejemplo
    override fun onCreate(savedInstanceState: Bundle?) {
        //aqui todos los demas empleados :D
        //para asegurarnos que sean 30 empleados:
        while (empleados.size<=29){
            empleados.add(Empleado("espacio vacio","espacio vacio","espacio vacio","espacio vacio"))
        }
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
                        liga.putParcelableArrayListExtra("empleados",empleados)
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
