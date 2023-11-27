package com.example.appmotoguia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appmotoguia.db.Db_Usuarios

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val itemuser = findViewById<EditText>(R.id.itemuser)
        val itemtelefono = findViewById<EditText>(R.id.itemtelefono)
        val itemcorreo = findViewById<EditText>(R.id.itemcorreo)
        val itempassword = findViewById<EditText>(R.id.itempassword)
        val buttoninscribirse = findViewById<Button>(R.id.buttoninscribirse)
        val rol = 2


        buttoninscribirse.setOnClickListener {
            val usuario = itemuser.text.toString()
            val telefono = itemtelefono.text.toString()
            val correo = itemcorreo.text.toString()
            val contraseña = itempassword.text.toString()
            val rol = 1

            if (usuario.isEmpty()) {
                Toast.makeText(this, "Se debe diligenciar el usuario", Toast.LENGTH_LONG).show()
            } else if (telefono.isEmpty()) {
                Toast.makeText(this, "Se debe diligenciar el teléfono", Toast.LENGTH_LONG).show()
            } else if (correo.isEmpty()) {
                Toast.makeText(this, "Se debe diligenciar el correo", Toast.LENGTH_LONG).show()
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                Toast.makeText(this, "El correo no es válido", Toast.LENGTH_LONG).show()
            } else if (contraseña.isEmpty()) {
                Toast.makeText(this, "Se debe diligenciar la contraseña", Toast.LENGTH_LONG).show()
            } else {

                val dbUsuarios = Db_Usuarios(this)
                val id = dbUsuarios.insertarUsuarios(
                    itemuser.text.toString(),
                    itemtelefono.text.toString(),
                    itemcorreo.text.toString(),
                    itempassword.text.toString(),
                    rol.toString()
                )

                if (id > 0) {
                    Toast.makeText(this, "Usuario Creado", Toast.LENGTH_LONG).show()
                    limpiarCampos()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)

                } else {
                    Toast.makeText(this, "Error al crear el usuario", Toast.LENGTH_LONG).show()
                }
            }
        }


        val imagenregresar = findViewById<ImageView>(R.id.imagenregresar)

        imagenregresar.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun limpiarCampos() {
        val itemuser = findViewById<EditText>(R.id.itemuser)
        val itemtelefono = findViewById<EditText>(R.id.itemtelefono)
        val itemcorreo = findViewById<EditText>(R.id.itemcorreo)
        val itempassword = findViewById<EditText>(R.id.itempassword)
        val buttoninscribirse = findViewById<Button>(R.id.buttoninscribirse)

        itemuser.text.clear()
        itemtelefono.text.clear()
        itemcorreo.text.clear()
        itempassword.text.clear()
    }
}
