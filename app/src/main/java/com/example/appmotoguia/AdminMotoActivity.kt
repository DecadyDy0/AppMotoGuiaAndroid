package com.example.appmotoguia

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.appmotoguia.db.Db_Motos

class AdminMotoActivity : AppCompatActivity() {

    lateinit var dbh: Db_Motos
    lateinit var umarca: ArrayList<String>
    lateinit var umodelo: ArrayList<String>
    lateinit var myAdapter: MyAdapter

    companion object {
        const val REQUEST_CODE_EDITAR_MOTO = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_moto)

        val recycleMoto = findViewById<RecyclerView>(R.id.recycleMoto)
        val floatingActionButton2 = findViewById<FloatingActionButton>(R.id.floatingActionButton2)
        dbh = Db_Motos(this)

        floatingActionButton2.setOnClickListener {
            abrirEditarMotoActivity()
        }

        umarca = ArrayList()
        umodelo = ArrayList()

        myAdapter = MyAdapter(this, umarca, umodelo)
        recycleMoto.layoutManager = LinearLayoutManager(this)
        recycleMoto.adapter = myAdapter

        displayData()

        val imageView = findViewById<ImageView>(R.id.imageView3)

        imageView.setOnClickListener{

            val intent = Intent(this, AdminIncioActivity::class.java)
            startActivity(intent)
        }
    }

    private fun displayData() {
        val cursor: Cursor = dbh.getdata()
        if (cursor.count == -1) {
            Toast.makeText(this, "No hay modelos", Toast.LENGTH_SHORT).show()
            return
        } else {

            umarca.clear()
            umodelo.clear()

            while (cursor.moveToNext()) {
                umarca.add(cursor.getString(1))
                umodelo.add(cursor.getString(2))
            }

            // Notificar al adaptador después de cargar los datos
            myAdapter.notifyDataSetChanged()
        }
    }

    private fun abrirEditarMotoActivity() {
        val intent = Intent(this, EditarMotoActivity::class.java)
        startActivityForResult(intent, REQUEST_CODE_EDITAR_MOTO)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_EDITAR_MOTO && resultCode == RESULT_OK) {
            // Si recibes un resultado de EditarMotoActivity, actualiza la lista
            displayData()
        }
    }
}