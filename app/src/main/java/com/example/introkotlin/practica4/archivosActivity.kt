package com.example.introkotlin.practica4

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
import java.io.FileNotFoundException

class archivosActivity : AppCompatActivity() {

    private lateinit var inputText: EditText
    private lateinit var outputText: TextView
    private lateinit var btnGuardar: Button
    private lateinit var btnLeer: Button
    private lateinit var btnBorrar: Button

    private val nombreArchivo = "datos.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_archivos)

        initViews()
        setupClickListeners()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initViews() {
        btnGuardar = findViewById(R.id.saveButton)
        btnLeer = findViewById(R.id.readButton)
        btnBorrar = findViewById(R.id.btnBorrar)
        inputText = findViewById(R.id.inputText)  // Cambié de TextView a EditText
        outputText = findViewById(R.id.outputText)
    }

    private fun setupClickListeners() {
        btnGuardar.setOnClickListener {
            guardarTexto()
        }

        btnLeer.setOnClickListener {
            leerTexto()
        }

        btnBorrar.setOnClickListener {
            borrarArchivo()
        }
    }

    private fun guardarTexto() {
        val texto = inputText.text.toString().trim()

        if (texto.isEmpty()) {
            Toast.makeText(this, "Por favor escribe algo antes de guardar", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            openFileOutput(nombreArchivo, MODE_APPEND).use { output ->
                output.write("$texto\n".toByteArray())
            }
            Toast.makeText(this, "Texto guardado correctamente", Toast.LENGTH_SHORT).show()
            inputText.setText("") // Limpiar el campo después de guardar
        } catch (e: Exception) {
            Toast.makeText(this, "Error al guardar: ${e.message}", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    private fun leerTexto() {
        try {
            val contenido = openFileInput(nombreArchivo).bufferedReader().use { reader ->
                reader.readText()
            }

            if (contenido.isNotEmpty()) {
                outputText.text = contenido
                Toast.makeText(this, "Archivo leído correctamente", Toast.LENGTH_SHORT).show()
            } else {
                outputText.text = "El archivo está vacío"
            }

        } catch (e: FileNotFoundException) {
            outputText.text = "Archivo no encontrado. Guarda algo primero."
            Toast.makeText(this, "Archivo no encontrado", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            outputText.text = "Error al leer el archivo"
            Toast.makeText(this, "Error al leer: ${e.message}", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    private fun borrarArchivo() {
        try {
            val archivoEliminado = deleteFile(nombreArchivo)
            if (archivoEliminado) {
                outputText.text = "Archivo eliminado"
                Toast.makeText(this, "Archivo borrado correctamente", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No se pudo borrar el archivo", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Error al borrar: ${e.message}", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }
}