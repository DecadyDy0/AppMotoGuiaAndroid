package com.example.appmotoguia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.appmotoguia.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonLogin = findViewById<AppCompatButton>(R.id.buttonLogin)
        val buttonRegister = findViewById<AppCompatButton>(R.id.buttonRegister)
        val buttonLogin2 = findViewById<AppCompatButton>(R.id.buttonLogin2)

        buttonLogin.setOnClickListener {
            val intent = Intent(this, IniciarSeccionAdminActivity::class.java)
            startActivity(intent)
        }

        buttonRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        buttonLogin2.setOnClickListener {
            val intent = Intent(this, IniciarSeccionActivity::class.java)
            startActivity(intent)
        }
    }
}
