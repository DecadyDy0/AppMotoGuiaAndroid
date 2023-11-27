package com.example.appmotoguia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.appmotoguia.R
import com.example.appmotoguia.db.Db_Motos
import android.widget.Toast

class EditarDatosMotoActivity : AppCompatActivity() {

    lateinit var dbh: Db_Motos
    lateinit var id_moto: AppCompatEditText  // Declarar aquí

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_datos_moto)

        val guardar = findViewById<AppCompatButton>(R.id.guardar)
        val eliminar = findViewById<AppCompatButton>(R.id.eliminar)
        val editTextText = findViewById<AppCompatEditText>(R.id.editTextText)
        val editTextText2 = findViewById<AppCompatEditText>(R.id.editTextText2)
        dbh = Db_Motos(this)
        id_moto = findViewById(R.id.id_moto)  // Inicializar aquí

        val intent = intent

        val marca = intent.getStringExtra("marca")
        val modelo = intent.getStringExtra("modelo")

        editTextText.setText(marca)
        editTextText2.setText(modelo)

        eliminar.setOnClickListener {
            val idMotoValue = id_moto.text.toString().toInt()
            val id = dbh.eliminarMoto(idMotoValue)
        }

        guardar.setOnClickListener {
            val idMoto = id_moto.text.toString().toIntOrNull()
            val nuevoModelo = editTextText.text.toString()
            val nuevaMarca = editTextText2.text.toString()
            val ano: Int = 2023

            val manual = ""
            val creado = ""
            val imagen = ByteArray(0)

            if (idMoto != null) {
                val filasAfectadas = dbh.actualizarMoto(idMoto,nuevoModelo,nuevaMarca,ano,manual,creado,imagen )

                if (filasAfectadas > 0) {
                    Toast.makeText(this, "Moto actualizada correctamente", Toast.LENGTH_SHORT).show()
                    // Puedes realizar acciones adicionales después de actualizar la moto, si es necesario
                } else {
                    Toast.makeText(this, "Error al actualizar la moto", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "ID de moto no válido", Toast.LENGTH_SHORT).show()
            }
        }

    }
}