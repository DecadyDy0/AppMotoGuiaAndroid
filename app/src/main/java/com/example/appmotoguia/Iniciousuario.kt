package com.example.appmotoguia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class Iniciousuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciousuario)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {

            val intent = Intent(this, IniciarSeccionActivity::class.java)
            startActivity(intent)

        }


        val btnMotos: Button = findViewById(R.id.button2)
        btnMotos.setOnClickListener {
            val intent = Intent(this, pantalla_moto::class.java)
            startActivity(intent)
        }

        val btnManuales: Button = findViewById(R.id.button3)
        btnManuales.setOnClickListener {
            val intent = Intent(this, pantalla_manuales::class.java)
            startActivity(intent)
        }

        val btnFallas: Button = findViewById(R.id.button4)
        btnFallas.setOnClickListener {
            val intent = Intent(this, pantalla_fallas::class.java)
            startActivity(intent)
        }

        val btnSoporte: Button = findViewById(R.id.button5)
        btnSoporte.setOnClickListener {
            val intent = Intent(this, pantalla_soporte::class.java)
            startActivity(intent)
        }
    }
}

