package com.example.appmotoguia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.appmotoguia.R
import com.example.appmotoguia.db.Db_Roles
import com.example.appmotoguia.db.Db_Usuarios


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        //val button2 = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.button2)
        val nombre = "admin"
        val usuario = "admin"
        val telefono = "123"
        val correo = "admin@gmail.com"
        val contraseña = "123"
        val id_rol = "1"

        val usuario1 = "jhonuser"
        val telefono1 = "123"
        val correo1 = "jhonuser@gmail.com"
        val contraseña1 = "123"
        val id_rol1 = "2"




        imageView.setOnClickListener{

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            try {
                val dbRoles = Db_Roles(this)
                val id = dbRoles.insertarRoles(nombre.toString())

                Log.d("MainActivity", "ID del nuevo rol: $id")

                if (id > 0) {
                    Toast.makeText(this, "Bienvenido", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Bienvenidos", Toast.LENGTH_LONG).show()
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
                Log.e("MainActivity", "Excepción al intentar crear el rol: ${ex.message}")
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_LONG).show()
            }


            try {
                val dbUsuarios = Db_Usuarios(this)
                val id = dbUsuarios.insertarUsuarios(usuario.toString() ,telefono.toString(),correo.toString(),contraseña.toString(),id_rol.toString())

                Log.d("MainActivity", "ID del nuevo rol: $id")

                if (id > 0) {
                    //Toast.makeText(this, "1 Bienvenido", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "1 Bienvenidos", Toast.LENGTH_LONG).show()
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
                Log.e("MainActivity", "Excepción al intentar crear el rol: ${ex.message}")
                //Toast.makeText(this, "1 Bienvenido", Toast.LENGTH_LONG).show()
            }

            try {
                val dbUsuarios = Db_Usuarios(this)
                val id = dbUsuarios.insertarUsuarios(usuario1.toString() ,telefono1.toString(),correo1.toString(),contraseña1.toString(),id_rol1.toString())

                Log.d("MainActivity", "ID del nuevo rol: $id")

                if (id > 0) {
                    //Toast.makeText(this, "1 Bienvenido", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "1 Bienvenidos", Toast.LENGTH_LONG).show()
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
                Log.e("MainActivity", "Excepción al intentar crear el rol: ${ex.message}")
                //Toast.makeText(this, "1 Bienvenido", Toast.LENGTH_LONG).show()
            }

        }



    }
}