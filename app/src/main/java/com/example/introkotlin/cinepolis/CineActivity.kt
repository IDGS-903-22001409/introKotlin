package com.example.introkotlin.cinepolis

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin.R

class CineActivity : AppCompatActivity() {
    private lateinit var etNombre: EditText
    private lateinit var etCompradores: EditText
    private lateinit var rgTarjeta: RadioGroup
    private lateinit var rbSi: RadioButton
    private lateinit var rbNo: RadioButton
    private lateinit var etBoletos: EditText
    private lateinit var tvPrecio: TextView
    private lateinit var btnCalcular: Button

    private val PRECIO_BOLETO = 12.000
    private val MAX_BOLETOS_POR_PERSONA = 7

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cine)

        etNombre = findViewById(R.id.etNombre)
        etCompradores = findViewById(R.id.etCompradores)
        rgTarjeta = findViewById(R.id.rgTarjeta)
        rbSi = findViewById(R.id.rbSi)
        rbNo = findViewById(R.id.rbNo)
        etBoletos = findViewById(R.id.etBoletos)
        tvPrecio = findViewById(R.id.tvPrecio)
        btnCalcular = findViewById(R.id.btnCalcular)

        btnCalcular.setOnClickListener {
            calcularPrecio()
        }
    }

    private fun calcularPrecio() {
        if (!validarCampos()) {
            return
        }

        val nombre = etNombre.text.toString()
        val numCompradores = etCompradores.text.toString().toInt()
        val tieneTarjeta = rbSi.isChecked
        val numBoletos = etBoletos.text.toString().toInt()

        val maxBoletos = numCompradores * MAX_BOLETOS_POR_PERSONA
        if (numBoletos > maxBoletos) {
            mostrarMensaje("No se pueden comprar más de 7 boletos por persona")
            return
        }
        var precioTotal = numBoletos * PRECIO_BOLETO

        val descuentoPorCantidad = when {
            numBoletos >= 3 && numBoletos <= 5 -> 0.15  // 15% de descuento
            numBoletos > 5 -> 0.20                     // 20% de descuento
            else -> 0.0                                // Sin descuento
        }

        val subtotal = precioTotal * (1 - descuentoPorCantidad)

        val precioFinal = if (tieneTarjeta) {
            subtotal * 0.9  // 10% de descuento adicional
        } else {
            subtotal
        }

        tvPrecio.text = String.format("$ %.2f", precioFinal)
    }

    private fun validarCampos(): Boolean {
        if (etNombre.text.isNullOrEmpty()) {
            mostrarMensaje("Por favor ingrese un nombre")
            return false
        }

        if (etCompradores.text.isNullOrEmpty()) {
            mostrarMensaje("Por favor ingrese el número de compradores")
            return false
        }

        if (!rbSi.isChecked && !rbNo.isChecked) {
            mostrarMensaje("Por favor seleccione si tiene tarjeta Cineco")
            return false
        }

        if (etBoletos.text.isNullOrEmpty()) {
            mostrarMensaje("Por favor ingrese el número de boletos")
            return false
        }

        try {
            val numCompradores = etCompradores.text.toString().toInt()
            val numBoletos = etBoletos.text.toString().toInt()

            if (numCompradores <= 0) {
                mostrarMensaje("El número de compradores debe ser mayor a cero")
                return false
            }

            if (numBoletos <= 0) {
                mostrarMensaje("El número de boletos debe ser mayor a cero")
                return false
            }

        } catch (e: NumberFormatException) {
            mostrarMensaje("Por favor ingrese valores numéricos válidos")
            return false
        }

        return true
    }

    private fun mostrarMensaje(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}