
package com.example.introkotlin.practica2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
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

class OperasActivity : AppCompatActivity() {
    private lateinit var edt1: EditText
    private lateinit var edt2: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var rbSuma: RadioButton
    private lateinit var rbResta: RadioButton
    private lateinit var rbMultiplicacion: RadioButton
    private lateinit var rbDivision: RadioButton
    private lateinit var btn1: Button
    private lateinit var tv1: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_operas)

        // Inicializar los componentes de la interfaz
        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        radioGroup = findViewById(R.id.radioGroup)
        rbSuma = findViewById(R.id.rbSuma)
        rbResta = findViewById(R.id.rbResta)
        rbMultiplicacion = findViewById(R.id.rbMultiplicacion)
        rbDivision = findViewById(R.id.rbDivision)
        btn1 = findViewById(R.id.btn1)
        tv1 = findViewById(R.id.tv1)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcular(view: View) {
        // Verificar que los campos no estén vacíos
        if (edt1.text.isEmpty() || edt2.text.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese ambos números", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val num1 = edt1.text.toString().toDouble()
            val num2 = edt2.text.toString().toDouble()
            var resultado = 0.0
            var operacion = ""

            // Determinar qué operación realizar según el RadioButton seleccionado
            when {
                rbSuma.isChecked -> {
                    resultado = num1 + num2
                    operacion = "suma"
                }
                rbResta.isChecked -> {
                    resultado = num1 - num2
                    operacion = "resta"
                }
                rbMultiplicacion.isChecked -> {
                    resultado = num1 * num2
                    operacion = "multiplicación"
                }
                rbDivision.isChecked -> {
                    if (num2 == 0.0) {
                        Toast.makeText(this, "No se puede dividir por cero", Toast.LENGTH_SHORT).show()
                        return
                    }
                    resultado = num1 / num2
                    operacion = "división"
                }
            }

            // Mostrar el resultado
            tv1.text = "Resultado de la $operacion: $resultado"

        } catch (e: Exception) {
            Toast.makeText(this, "Error en los cálculos", Toast.LENGTH_SHORT).show()
        }
    }
}
