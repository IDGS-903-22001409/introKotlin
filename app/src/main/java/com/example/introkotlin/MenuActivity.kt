package com.example.introkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin.practica1.SaludoActivity
import com.example.introkotlin.practica3.Ejemplo3Activity
import com.example.introkotlin.practica4.archivosActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        // Referencias a los botones
        val btnSaludo = findViewById<Button>(R.id.btn1)
        val btnEjemplo3 = findViewById<Button>(R.id.btn3)
        val btnEjemplo4 = findViewById<Button>(R.id.btn4)

        // Configurar listeners para los botones
        btnSaludo.setOnClickListener {
            navegateToSaludo()
        }

        btnEjemplo3.setOnClickListener {
            navegateToEjemplo3()
        }

        btnEjemplo4.setOnClickListener {
            navegateToEjemplo4()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navegateToSaludo() {
        val intent = Intent(this, SaludoActivity::class.java)
        startActivity(intent)
    }

    private fun navegateToEjemplo3() {
        val intent = Intent(this, Ejemplo3Activity::class.java)
        startActivity(intent)
    }

    private fun navegateToEjemplo4() {
        val intent = Intent(this, archivosActivity::class.java)
        startActivity(intent)
    }
}