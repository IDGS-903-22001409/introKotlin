package com.example.introkotlin.practica3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin.R
import kotlin.random.Random

class Ejemplo3Activity : AppCompatActivity() {
    private lateinit var tv1: TextView
    private lateinit var edt1: EditText
    private lateinit var button: Button
    private var num = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo3)

        // Inicializar las vistas
        initViews()

        // Generar número aleatorio
        num = Random.nextInt(0, 100001)
        val cadena = num.toString()

        // Mostrar el número generado
        Toast.makeText(this, "Número generado: $cadena", Toast.LENGTH_LONG).show()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initViews() {
        tv1 = findViewById(R.id.tv1)
        edt1 = findViewById(R.id.ed1)
        button = findViewById(R.id.button)
    }

    fun controlar(view: android.view.View) {
        val valorIngresado: String = edt1.text.toString().trim()

        // Validar que el campo no esté vacío
        if (valorIngresado.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese un número", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val valor = valorIngresado.toInt()

            if (valor == num) {
                Toast.makeText(this, "¡Correcto! 🎉", Toast.LENGTH_LONG).show()
                // Generar un nuevo número para el siguiente intento
                generateNewNumber()
            } else {
                val mensaje = if (valor < num) {
                    "Incorrecto. El número es mayor que $valor"
                } else {
                    "Incorrecto. El número es menor que $valor"
                }
                Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
            }
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Por favor ingrese un número válido", Toast.LENGTH_SHORT).show()
        }
    }

    private fun generateNewNumber() {
        num = Random.nextInt(0, 100001)
        Toast.makeText(this, "Nuevo número generado: $num", Toast.LENGTH_LONG).show()
        edt1.setText("") // Limpiar el campo de entrada
    }
}