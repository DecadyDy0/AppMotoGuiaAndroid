package com.example.appmotoguia

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appmotoguia.db.Db_Motos
import com.google.android.material.textfield.TextInputLayout
import androidx.appcompat.widget.AppCompatButton

class EditarMotoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_moto)

        val textInputLayout =
            findViewById<TextInputLayout>(R.id.textInputLayout)
        val textInputLayoutv2 =
            findViewById<TextInputLayout>(R.id.textInputLayoutv2)
        val button = findViewById<AppCompatButton>(R.id.button)
        val ano = ""
        val manual = ""
        val creado = ""
        val imagen = ByteArray(0)

        button.setOnClickListener {
            val marca = textInputLayout.editText?.text.toString()
            val modelo = textInputLayoutv2.editText?.text.toString()

            if (marca.isEmpty()) {
                Toast.makeText(this, "Se debe diligenciar la marca", Toast.LENGTH_LONG).show()
            } else if (modelo.isEmpty()) {
                Toast.makeText(this, "Se debe diligenciar el modelo", Toast.LENGTH_LONG).show()
            } else {
                val db_Motos = Db_Motos(this)
                val id = db_Motos.insertarMotos(
                    modelo,
                    marca,
                    ano,
                    manual,
                    creado,
                    imagen
                )
                if (id > 0) {
                    Toast.makeText(this, "Datos Creados", Toast.LENGTH_LONG).show()
                    limpiarCampos()

                    setResult(RESULT_OK)
                    finish()
                } else {
                    Toast.makeText(this, "Error al crear los datos", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun limpiarCampos() {
        val textInputLayout =
            findViewById<TextInputLayout>(R.id.textInputLayout)
        val textInputLayoutv2 =
            findViewById<TextInputLayout>(R.id.textInputLayoutv2)

        textInputLayout.editText?.text?.clear()
        textInputLayoutv2.editText?.text?.clear()
    }
}